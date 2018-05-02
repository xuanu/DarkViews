package views.zeffect.cn.darklib;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * <pre>
 *      author  ：zzx
 *      e-mail  ：zhengzhixuan18@gmail.com
 *      time    ：2017/09/26
 *      desc    ：
 *      version:：1.0
 * </pre>
 *
 * @author zzx
 */

public class DarkButton extends Button {
    public DarkButton(Context context) {
        super(context);
    }

    public DarkButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DarkButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private ColorStateList mColors;
    private int mColor = 0;

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        if (mColors == null) mColors = getTextColors();
        if (mColor == 0) {
            mColor = mColors.getColorForState(new int[]{}, Color.GRAY);
            int alpha = (int) (Color.alpha(mColor) * 0.5);
            mColor = Color.argb(alpha, Color.red(mColor), Color.green(mColor), Color.blue(mColor));
        }
        if (pressed) {
            setTextColor(mColor);
            for (int tempI = 0; tempI < getCompoundDrawables().length; tempI++) {
                if (getCompoundDrawables()[tempI] != null) {
                    getCompoundDrawables()[tempI].setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                }
            }
            if (getBackground() != null)
                getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
        } else {
            setTextColor(mColors);
            for (int tempI = 0; tempI < getCompoundDrawables().length; tempI++) {
                if (getCompoundDrawables()[tempI] != null) {
                    getCompoundDrawables()[tempI].clearColorFilter();
                }
            }
            if (getBackground() != null) getBackground().clearColorFilter();
        }
    }
}
