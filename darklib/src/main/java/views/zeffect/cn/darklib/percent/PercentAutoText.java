package views.zeffect.cn.darklib.percent;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
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
        if (attributeSet != null) {
            if (attributeSet != null) {
                TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.Dark);
                baseScreenHeight = typedArray.getInt(R.styleable.Dark_screenHeight, baseScreenHeight);
                autoTractics = typedArray.getString(R.styleable.Dark_wOrh);
                originalTextSize = typedArray.getInt(R.styleable.Dark_textSize, 20);
                typedArray.recycle();
            }
        }
        setTextSize(originalTextSize);
        setLines(1);
        setSingleLine(true);
    }


//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int heightModel = MeasureSpec.getMode(heightMeasureSpec);
//        boolean unspHeight = false;
//        switch (heightModel) {
//            case MeasureSpec.AT_MOST:
//                canAdjustHeight = true;
//                break;
//            case MeasureSpec.EXACTLY:
//                canAdjustHeight = true;
//                break;
//            case MeasureSpec.UNSPECIFIED:
//                canAdjustHeight = false;
//                unspHeight = true;
//                break;
//        }
//        boolean unspWidth = false;
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        switch (widthMode) {
//            case MeasureSpec.AT_MOST:
//                canAdjustWidth = true;
//                break;
//            case MeasureSpec.EXACTLY:
//                canAdjustWidth = true;
//                break;
//            case MeasureSpec.UNSPECIFIED:
//                canAdjustWidth = false;
//                unspWidth = true;
//                break;
//        }
//        Paint paint = new Paint();
//        paint.setTextSize(originalTextSize);
//        int needWidth = (int) paint.measureText(this.getText().toString());//需要这么宽
//        Paint textPaint = new Paint();
//        textPaint.setTextSize(originalTextSize);
//        Paint.FontMetrics fm = textPaint.getFontMetrics();
//        int needHeight = (int) Math.ceil(fm.descent - fm.ascent);
//        if (unspHeight && unspWidth) {
//            setMeasuredDimension(needWidth, needHeight);
//        } else if (unspHeight) {
//            setMeasuredDimension(widthMeasureSpec, needHeight);
//        } else if (unspWidth) {
//            setMeasuredDimension(needWidth, heightMeasureSpec);
//        }
//    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) setTextSize(originalTextSize);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        setTextSize(originalTextSize);
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
        float defaultSize = 20f;
        if (size <= 0) return defaultSize;
        size = (int) (size * getDefaultPercent(this.getContext()));
        if (TextUtils.isEmpty(autoTractics)) return size;
        if (autoTractics.equals(TRACTICS_WIDTH)) {

            int avaiWidth = getWidth() - this.getPaddingLeft() - this.getPaddingRight() - 10;
            if (avaiWidth <= 0) {
                return defaultSize;
            }
            TextPaint textPaintClone = new TextPaint();
            textPaintClone.setTextSize(size);
            float trySize = size;
            while (textPaintClone.measureText(getText().toString()) > avaiWidth) {
                trySize--;
                if (trySize < 0) break;
                textPaintClone.setTextSize(trySize);
            }
            return trySize;

        } else if (autoTractics.equals(TRACTICS_HEIGHT)) {

            int avaiHeight = getHeight() - getPaddingTop() - getPaddingBottom() - 10;
            if (avaiHeight <= 0) return defaultSize;
            Paint textPaint = new Paint();
            textPaint.setTextSize(size);
            Paint.FontMetrics fm = textPaint.getFontMetrics();
            float trySize = size;
            while (Math.ceil(fm.descent - fm.ascent) > avaiHeight) {
                trySize--;
                if (trySize < 0) break;
                textPaint.setTextSize(trySize);
                fm = textPaint.getFontMetrics();
            }
            return trySize;
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
