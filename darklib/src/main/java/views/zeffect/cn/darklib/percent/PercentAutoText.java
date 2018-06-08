package views.zeffect.cn.darklib.percent;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.EventLog;
import android.util.Log;
import android.util.TypedValue;

import views.zeffect.cn.darklib.DarkText;
import views.zeffect.cn.darklib.R;

public class PercentAutoText extends DarkText {
    public static final String TRACTICS_WIDTH = "1", TRACTICS_HEIGHT = "2";

    private static int baseScreenHeight = 800;
    private float originalTextSize = 20f;
    private String autoTractics;

    public PercentAutoText(Context context) {
        super(context);
        init(null);
    }

    public PercentAutoText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public PercentAutoText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        originalTextSize = getTextSize();
        if (attributeSet != null) {
            if (attributeSet != null) {
                TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.Dark);
                baseScreenHeight = typedArray.getInt(R.styleable.Dark_baseScreenHeight, baseScreenHeight);
                autoTractics = typedArray.getString(R.styleable.Dark_autoTactics);
                typedArray.recycle();
            }
        }
        setTextSize(originalTextSize);
        setLines(1);
        setSingleLine(true);
    }

    private boolean canAdjustWidth = true;
    private boolean canAdjustHeight = true;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightModel = MeasureSpec.getMode(heightMeasureSpec);
        switch (heightModel) {
            case MeasureSpec.AT_MOST:
                canAdjustHeight = true;
                break;
            case MeasureSpec.EXACTLY:
                canAdjustHeight = true;
                break;
            case MeasureSpec.UNSPECIFIED:
                canAdjustHeight = false;
                break;
        }

        //检查能否根据宽高进行调整
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        switch (widthMode) {
            case MeasureSpec.AT_MOST:
                canAdjustWidth = true;
                break;
            case MeasureSpec.EXACTLY:
                canAdjustWidth = true;
                break;
            case MeasureSpec.UNSPECIFIED:
                canAdjustWidth = false;
                break;
        }
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        setTextSize(originalTextSize);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) setTextSize(originalTextSize);
    }

    @Override
    public void setTextSize(int unit, float size) {
        size = adjustSize(size);
        super.setTextSize(unit, size);
    }

    @Override
    public void setTextSize(float size) {
        setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }


    private float adjustSize(float size) {
        Log.e("zeffect", "adjust size:" + System.currentTimeMillis());
        float defaultSize = 20f;
        if (size <= 0) return defaultSize;
        size = (int) (size * getDefaultPercent(this.getContext()));
        if (TextUtils.isEmpty(autoTractics)) return size;
        if (autoTractics.equals(TRACTICS_WIDTH)) {
            if (canAdjustWidth) {
                Log.e("zeffect", "width:" + getWidth());
                int avaiWidth = getWidth() - this.getPaddingLeft() - this.getPaddingRight() - 10;
                if (avaiWidth <= 0) {
                    return defaultSize;
                }
                TextPaint textPaintClone = new TextPaint();
                textPaintClone.setTextSize(size);
                float trySize = size;
                while (textPaintClone.measureText(getText().toString()) > avaiWidth) {
                    Log.e("zeffect", "in width while");
                    trySize--;
                    if (trySize < 0) break;
                    textPaintClone.setTextSize(trySize);
                }
                return trySize;
            }
        } else if (autoTractics.equals(TRACTICS_HEIGHT)) {
            if (canAdjustHeight) {
                Log.e("zeffect", "height:" + getHeight());
                int avaiHeight = getHeight() - getPaddingTop() - getPaddingBottom() - 10;
                if (avaiHeight <= 0) return defaultSize;
                Paint textPaint = new Paint();
                textPaint.setTextSize(size);
                Paint.FontMetrics fm = textPaint.getFontMetrics();
                float trySize = size;
                while ((int) Math.ceil(fm.descent - fm.ascent) > avaiHeight) {
                    Log.e("zeffect", "in height while");
                    trySize--;
                    if (trySize < 0) break;
                    textPaint.setTextSize(trySize);
                    fm=textPaint.getFontMetrics();
                }
                return trySize;
            }
        }
        return size;
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setTextSize(originalTextSize);
    }

    /**
     * 设置默认的百分比
     *
     * @param context
     */
    private float getDefaultPercent(Context context) {
        float screenHeight = context.getResources().getDisplayMetrics().heightPixels;
        float mTextSizePercent = screenHeight / baseScreenHeight;
        if (mTextSizePercent == 0) mTextSizePercent = 1f;
        return mTextSizePercent;
    }
}
