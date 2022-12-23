package com.example.testofindia.utils;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import androidx.core.content.FileProvider;

import com.example.testofindia.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.Random;

public class TakePicture {
    private Uri outPutFileUri;
    private final Activity mContext;
    private String TAG = TakePicture.class.getSimpleName();
    private int CAMERA_CAPTURE = 100;
    private int GALLERY = 101;
    private int CROP_CODE = 203;
    private int PERMISSION_FOR_CAMERA = 11;

    public TakePicture(Activity mContext) {
        this.mContext = mContext;
    }

    public void selectImage() throws IOException {
        final CharSequence[] items = {mContext.getResources().getString(R.string.take_new_photo),
                mContext.getResources().getString(R.string.select_from_photo), mContext.getResources().getString(R.string.cancel)};
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(mContext.getResources().getString(R.string.add_photo));
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals(mContext.getResources().getString(R.string.take_new_photo))) {

                    try {
                        captureImageUsingCamera();
                        dialog.dismiss();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (items[item].equals(mContext.getResources().getString(R.string.select_from_photo))) {

                    pickImageFromGallery();
                    dialog.dismiss();
                } else if (items[item].equals(mContext.getResources().getString(R.string.cancel))) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    // Capture Image From Camera
    public void captureImageUsingCamera() throws ActivityNotFoundException, IOException {
        Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            File file = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                OutputStream out = null;
                ContentResolver contentResolver = mContext.getContentResolver();
                ContentValues contentValues = new ContentValues();
                Random generator = new Random();
                int n = 10000;
                n = generator.nextInt(n);
                contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, "Image_" + n + ".jpeg");
                contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg");
                contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + File.separator + mContext.getResources().getString(R.string.app_name));
                outPutFileUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                out = contentResolver.openOutputStream(Objects.requireNonNull(outPutFileUri));
                //finalBitmap.compress(Bitmap.CompressFormat.JPEG, quality, out);
                Objects.requireNonNull(out);
                String abc = Environment.getExternalStorageDirectory()
                        + "/" + Environment.DIRECTORY_PICTURES
                        + File.separator + mContext.getResources().getString(R.string.app_name)
                        //+ mContext.getResources().getString(R.string.app_name)
                        + "/" + "Image_" + n + ".jpeg";
                file = new File(abc);
                Log.e(TAG, "saveImageAsPerQuality: >>>>>>>" + file, null);
                out.flush();
                out.close();
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
                outPutFileUri = FileProvider.getUriForFile(mContext, "com.myavin.myavin" + ".provider", createImageFile());
            } else {
                outPutFileUri = Uri.fromFile(createImageFile());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            outPutFileUri = FileProvider.getUriForFile(mContext, BuildConfig.APPLICATION_ID + ".provider", createImageFile());
        } else {
            outPutFileUri = Uri.fromFile(createImageFile());
        }*/
        captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, outPutFileUri);
        mContext.startActivityForResult(captureIntent, CAMERA_CAPTURE);
    }

    // Pick Image From Gallery
    public void pickImageFromGallery() throws ActivityNotFoundException {
        Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        mContext.startActivityForResult(pickIntent, GALLERY);
    }

    public String onActivityResult(int requestCode, int resultCode, Intent data) throws IOException {
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_CAPTURE) {
                if (outPutFileUri != null) {
                    cropImage(outPutFileUri);
//                    performCrop(outPutFileUri);
                }
            } else if (requestCode == GALLERY && data != null) {
                Uri fileUri = data == null ? null : data.getData();
                if (fileUri != null) {
                    cropImage(fileUri);
//                    performCrop(fileUri);
                }
            } else if (requestCode == CROP_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                Uri resultUri = result.getUri();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), resultUri);
                return reduceImageSize(1000, 90, bitmap);
            }
        } else {
            return "";
        }
        return "";
    }

    private void cropImage(Uri mUri) {
        CropImage.activity(mUri).setGuidelines(CropImageView.Guidelines.ON).start(mContext);
    }

    public String reduceImageSize(int maxSize, int quality, Bitmap image) throws IOException {
        int mWidth, mHeight;
        if (image.getWidth() > image.getHeight()) {
            mWidth = maxSize;
            mHeight = Math.round((maxSize * image.getHeight()) / image.getWidth());
            return saveImageAsPerQuality(resizeBitmap(image, mWidth, mHeight), quality);
        } else if (image.getHeight() > image.getWidth()) {
            mHeight = maxSize;
            mWidth = Math.round((maxSize * image.getWidth()) / image.getHeight());
            return saveImageAsPerQuality(resizeBitmap(image, mWidth, mHeight), quality);
        } else if (image.getHeight() == image.getWidth() && image.getHeight() > maxSize) {
            mHeight = maxSize;
            mWidth = maxSize;
            return saveImageAsPerQuality(resizeBitmap(image, mWidth, mHeight), quality);
        } else {
            return saveImageAsPerQuality(image, quality);
        }
    }

    // For File Store
    private File createImageFile() throws IOException {
        File file = null;
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                OutputStream out = null;
                ContentResolver contentResolver = mContext.getContentResolver();
                ContentValues contentValues = new ContentValues();
                Random generator = new Random();
                int n = 1000000000;
                n = generator.nextInt(n);
                contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, "Image_" + n + ".jpeg");
                contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg");
                contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + File.separator + mContext.getResources().getString(R.string.app_name));
                Uri imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                out = contentResolver.openOutputStream(Objects.requireNonNull(imageUri));
                // finalBitmap.compress(Bitmap.CompressFormat.JPEG, quality, out);
                Objects.requireNonNull(out);
                String abc = Environment.getExternalStorageDirectory()
                        + "/" + Environment.DIRECTORY_PICTURES
                        + File.separator + ""
                        + mContext.getResources().getString(R.string.app_name)
                        + "/" + "Image_" + n + ".jpeg";
                file = new File(abc);
                Log.e(TAG, "saveImageAsPerQuality: >>>>>>>" + file, null);
                out.flush();
                out.close();
            } else {
                File myDir;
                String FolderName = mContext.getResources().getString(R.string.app_name);
                if (FolderName.equalsIgnoreCase("")) {
                    myDir = new File(Environment.getExternalStorageDirectory().toString() + mContext.getResources().getString(R.string.app_name) + "/saved_images");
                } else {
                    myDir = new File(Environment.getExternalStorageDirectory().toString() + mContext.getResources().getString(R.string.app_name) + "/." + FolderName);
                }
                myDir.mkdirs();
                Random generator = new Random();
                int n = 10000;
                n = generator.nextInt(n);
                String fname = "Image_" + n + ".jpeg";
                file = new File(myDir, fname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*File myDir;
        String FolderName = mContext.getResources().getString(R.string.app_name);
        if (FolderName.equalsIgnoreCase("")) {
            myDir = new File(ImagePermission.SDCARD + "/saved_images");
        } else {
            myDir = new File(ImagePermission.SDCARD + "/." + FolderName);
        }

        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image_" + n + ".jpeg";
        File file = new File(myDir, fname);*/
        return file;
    }

    private Bitmap resizeBitmap(Bitmap mBitmap, int mWidth, int mHeight) {
        return Bitmap.createScaledBitmap(mBitmap, mWidth, mHeight, false);
    }

    private String saveImageAsPerQuality(Bitmap finalBitmap, int quality) throws IOException {
        File file = createImageFile();
        if (file.exists()) file.delete();
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                OutputStream out = null;
                ContentResolver contentResolver = mContext.getContentResolver();
                ContentValues contentValues = new ContentValues();
                Random generator = new Random();
                int n = 10000;
                n = generator.nextInt(n);
                contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, "Image_" + n + ".jpeg");
                contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg");
                contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + File.separator + mContext.getResources().getString(R.string.app_name));
                Uri imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                out = contentResolver.openOutputStream(Objects.requireNonNull(imageUri));
                finalBitmap.compress(Bitmap.CompressFormat.JPEG, quality, out);
                Objects.requireNonNull(out);
                String abc = Environment.getExternalStorageDirectory()
                        + "/" + Environment.DIRECTORY_PICTURES
                        + File.separator + mContext.getResources().getString(R.string.app_name)
                        //+ mContext.getResources().getString(R.string.app_name)
                        + "/" + "Image_" + n + ".jpeg";
                file = new File(abc);
                Log.e(TAG, "saveImageAsPerQuality: >>>>>>>" + file, null);
                out.flush();
                out.close();
            } else {
                FileOutputStream out = new FileOutputStream(file);
                finalBitmap.compress(Bitmap.CompressFormat.JPEG, quality, out);
                out.flush();
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }
}
