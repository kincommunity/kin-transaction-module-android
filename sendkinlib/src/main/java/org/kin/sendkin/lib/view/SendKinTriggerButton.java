package org.kin.sendkin.lib.view;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.TypedValue;

import org.kin.sendkin.lib.R;

public class SendKinTriggerButton extends AppCompatButton {
    public SendKinTriggerButton(Context context) {
        super(context);
        init();
    }

    public SendKinTriggerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        setAllCaps(false);
        setText(R.string.kin_send_kin_trigger_button);
        setTextColor(getResources().getColor(R.color.kin_white));
        setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_purple_background));
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
    }
}
