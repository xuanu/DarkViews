package views.zeffect.cn.darklib.percent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;

import views.zeffect.cn.darklib.DarkText;
import views.zeffect.cn.darklib.R;


/***
 * 百分比调整字体大小
 *
 *
 *
 */
public class PercentText extends DarkText {

    private static int baseScreenHeight = 800;
    private float originalTextSize = 0f;

    public PercentText(Context context) {
        super(context);
        init(null);
    }

    public PercentText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public PercentText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            if (attributeSet != null) {
                TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.Dark);
                baseScreenHeight = typedArray.getInt(R.styleable.Dark_baseScreenHeight, baseScreenHeight);
                originalTextSize = typedArray.getInt(R.styleable.Dark_textSize, 20);
                typedArray.recycle();
            }
        }
        setTextSize(originalTextSize);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) {
            setTextSize(originalTextSize);
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        setTextSize(originalTextSize);
    }

    @Override
    public void setTextSize(int unit, float size) {
        float defaultSize = size;
        size = (int) (defaultSize * getDefaultPercent(this.getContext()));
        super.setTextSize(unit, size);
    }

    @Override
    public void setTextSize(float size) {
        setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
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
