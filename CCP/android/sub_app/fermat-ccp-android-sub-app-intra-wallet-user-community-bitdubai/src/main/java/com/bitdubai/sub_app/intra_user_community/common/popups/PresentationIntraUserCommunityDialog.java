package com.bitdubai.sub_app.intra_user_community.common.popups;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.bitdubai.fermat_android_api.layer.definition.wallet.views.FermatButton;
import com.bitdubai.fermat_android_api.ui.dialogs.FermatDialog;
import com.bitdubai.fermat_api.layer.all_definition.settings.exceptions.CantGetSettingsException;
import com.bitdubai.fermat_api.layer.all_definition.settings.exceptions.CantPersistSettingsException;
import com.bitdubai.fermat_api.layer.all_definition.settings.exceptions.SettingsNotFoundException;
import com.bitdubai.fermat_api.layer.all_definition.settings.structure.SettingsManager;
import com.bitdubai.fermat_ccp_api.layer.actor.intra_user.interfaces.IntraUserWalletSettings;
import com.bitdubai.fermat_ccp_api.layer.module.intra_user.exceptions.CouldNotCreateIntraUserException;
import com.bitdubai.fermat_ccp_api.layer.module.intra_user.interfaces.IntraUserModuleManager;
import com.bitdubai.fermat_pip_api.layer.network_service.subapp_resources.SubAppResourcesProviderManager;
import com.bitdubai.sub_app.intra_user_community.R;
import com.bitdubai.sub_app.intra_user_community.constants.Constants;
import com.bitdubai.sub_app.intra_user_community.interfaces.RecreateView;
import com.bitdubai.sub_app.intra_user_community.session.IntraUserSubAppSession;

import java.io.ByteArrayOutputStream;

/**
 * @author Jose manuel de Sousa
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class PresentationIntraUserCommunityDialog extends FermatDialog<IntraUserSubAppSession, SubAppResourcesProviderManager> implements View.OnClickListener {


    public static final int TYPE_PRESENTATION = 1;
    public static final int TYPE_PRESENTATION_WITHOUT_IDENTITIES = 2;
    private final Activity activity;
    private final int type;
    private FermatButton startCommunity;
    private CheckBox dontShowAgainCheckBox;
    private Button btn_left;
    private Button btn_right;
    private ImageView image_view_left;
    private FrameLayout container_john_doe;
    private ImageView image_view_right;
    private FrameLayout container_jane_doe;
    private IntraUserSubAppSession intraUserSubAppSession;
    private IntraUserModuleManager moduleManager;
    private RecreateView recreateView;

    /**
     * Constructor using Session and Resources
     *
     * @param fermatSession parent class of walletSession and SubAppSession
     * @param resources     parent class of WalletResources and SubAppResources
     */
    public PresentationIntraUserCommunityDialog(final Activity activity,
                                                final IntraUserSubAppSession fermatSession,
                                                final SubAppResourcesProviderManager resources,
                                                final IntraUserModuleManager moduleManager,
                                                final int type) {

        super(activity, fermatSession, resources);

        this.activity = activity;
        this.type = type;
        this.moduleManager = moduleManager;
        this.intraUserSubAppSession = fermatSession;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (type) {
            case TYPE_PRESENTATION:
                dontShowAgainCheckBox = (CheckBox) findViewById(R.id.checkbox_not_show);
                image_view_left = (ImageView) findViewById(R.id.image_view_left);
                image_view_right = (ImageView) findViewById(R.id.image_view_right);
                container_john_doe = (FrameLayout) findViewById(R.id.container_john_doe);
                container_jane_doe = (FrameLayout) findViewById(R.id.container_jane_doe);
                btn_left = (Button) findViewById(R.id.btn_left);
                btn_right = (Button) findViewById(R.id.btn_right);
                btn_left.setOnClickListener(this);
                btn_right.setOnClickListener(this);
                break;
            case TYPE_PRESENTATION_WITHOUT_IDENTITIES:
                dontShowAgainCheckBox = (CheckBox) findViewById(R.id.checkbox_not_show);
                startCommunity = (FermatButton) findViewById(R.id.start_community);
                startCommunity.setOnClickListener(this);
                break;
        }

        dontShowAgainCheckBox.setChecked(true);
    }

    @Override
    protected int setLayoutId() {
        switch (type) {
            case TYPE_PRESENTATION:
                return R.layout.tutorial_intra_user_community;
            case TYPE_PRESENTATION_WITHOUT_IDENTITIES:
                return R.layout.tutorial_intra_user_community_whitout_identity;
        }
        return 0;
    }

    @Override
    protected int setWindowFeature() {
        return Window.FEATURE_NO_TITLE;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        SharedPreferences pref = getContext().getSharedPreferences(Constants.PRESENTATIO_DIALOG_CHECKED, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit;
        if (id == R.id.btn_left) {
            try {
                moduleManager.createIntraUser("Jhon Doe", "Available", convertImage(R.drawable.ic_profile_male));
                if (recreateView != null)
                    recreateView.recreate();
                if (dontShowAgainCheckBox.isChecked()) {
                    pref.edit().putBoolean("isChecked", false).apply();
                }
                saveSettings();
                dismiss();
                Toast.makeText(getActivity(), "Identity created", Toast.LENGTH_SHORT).show();
            } catch (CouldNotCreateIntraUserException e) {
                e.printStackTrace();
            }
        } else if (id == R.id.btn_right) {
            try {
                moduleManager.createIntraUser("Jane Doe", "Available", convertImage(R.drawable.img_profile_female));
                if (recreateView != null) {
                    recreateView.recreate();
                }
                if (dontShowAgainCheckBox.isChecked()) {
                    pref.edit().putBoolean("isChecked", false).apply();
                }
                saveSettings();
                dismiss();
                Toast.makeText(getActivity(), "Identity created", Toast.LENGTH_SHORT).show();
            } catch (CouldNotCreateIntraUserException e) {
                e.printStackTrace();
            }
        } else if (id == R.id.start_community) {
            if (dontShowAgainCheckBox.isChecked()) {
                pref.edit().putBoolean("isChecked", false).apply();
            }
            saveSettings();
            dismiss();
        }
    }

    private void saveSettings(){
        if(type!=TYPE_PRESENTATION)
                if(dontShowAgainCheckBox.isChecked()){
                    SettingsManager<IntraUserWalletSettings> settingsManager = moduleManager.getSettingsManager();
                    try {

                        IntraUserWalletSettings intraUserWalletSettings = settingsManager.loadAndGetSettings(getSession().getAppPublicKey());
                        intraUserWalletSettings.setIsPresentationHelpEnabled(!dontShowAgainCheckBox.isChecked());
                        settingsManager.persistSettings(getSession().getAppPublicKey(),intraUserWalletSettings);
                    } catch (CantGetSettingsException | SettingsNotFoundException | CantPersistSettingsException e) {
                        e.printStackTrace();
                    }
                }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        intraUserSubAppSession.setData(Constants.PRESENTATION_DIALOG_DISMISS, Boolean.TRUE);
    }

    private byte[] convertImage(int resImage) {
        Bitmap bitmap = BitmapFactory.decodeResource(activity.getResources(), resImage);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
       // bitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public void setRecreateView(RecreateView recreateView) {
        this.recreateView = recreateView;
    }
}
