package views.zeffect.cn.darklib;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ImageView;

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

public class DarkImage extends ImageView {
    public DarkImage(Context context) {
        super(context);
    }

    public DarkImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DarkImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        if (pressed) {
            if (getBackground() != null)
                getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
            if (getDrawable() != null)
                getDrawable().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
        } else {
            if (getBackground() != null) getBackground().clearColorFilter();
            if (getDrawable() != null) getDrawable().clearColorFilter();
        }
    }
}
