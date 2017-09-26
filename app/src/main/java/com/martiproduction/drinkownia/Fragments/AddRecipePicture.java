package com.martiproduction.drinkownia.Fragments;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.martiproduction.drinkownia.R;
import com.martiproduction.drinkownia.core.CameraV2;
import com.martiproduction.drinkownia.core.RecipePictureListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by marcin on 13.07.2017.
 */

public class AddRecipePicture extends Fragment implements RecipePictureListener{

    private boolean mCameraPermissionGranted;
    private Unbinder bind;
  //  private PopupTitle mPopupTitle;
    private View mView;
    private CameraV2 mCameraV2;
    private PickingImage.Listener mPickingImageListener;

    @BindView(R.id.addPicture_circlePreview)
    TextureView circlePreview;

    @BindView(R.id.addPicture_takePictureButton)
    FloatingActionButton takePictureButton;

    @Override
    public void onPause() {
        if(mCameraV2 != null)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mCameraV2.pause();
            }
        super.onPause();
    }

    @Override
    public void onDestroy() {
        bind.unbind();
    //    mPopupTitle.destroy();
        super.onDestroy();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_add_recipe_picture,container,false);
        bind = ButterKnife.bind(this,mView);

        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();

    //    mPopupTitle = new PopupTitle(getActivity().getApplicationContext(),mView);
        mView.post(() -> {
      //      mPopupTitle.show(getString(R.string.addDrink_add_picture),5);
            openCamera(mCameraPermissionGranted);

        });

    }

    public void cameraPermission(boolean permission){
        mCameraPermissionGranted = permission;
    }

    public void setPickingImageListener(PickingImage.Listener pickingImageListener) {
        this.mPickingImageListener = pickingImageListener;
    }


    @OnClick(R.id.addPicture_pickPictureButton)
    public void pickPictureButton(){
        mPickingImageListener.buttonClicked();
    }


    private void openCamera(boolean permission){
        if (!permission){
            Log.d(getActivity().getLocalClassName(),"DUMMY PICTURE");
            takePictureButton.setEnabled(false);
            }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                if(mCameraV2 != null)
                        mCameraV2.resume();

                else {
                    mCameraV2 = new CameraV2(getActivity());
                    mCameraV2.openCamera(circlePreview);
                }
            }
        }
    }



    @Override
    public void getPicture(byte[] picture) {

    }
}
