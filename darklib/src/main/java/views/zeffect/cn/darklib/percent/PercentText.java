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
        originalTextSize = getTextSize();
        if (attributeSet != null) {
            if (attributeSet != null) {
                TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.Dark);
                baseScreenHeight = typedArray.getInt(R.styleable.Dark_baseScreenHeight, baseScreenHeight);
                typedArray.recycle();
            }
        }
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
