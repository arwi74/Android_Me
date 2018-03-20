/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{
    int mHeadIndex;
    int mBodyIndex;
    int mLegsIndex;
    public static final String EXTRA_HEAD_INDEX = "head_index";
    public static final String EXTRA_BODY_INDEX = "body_index";
    public static final String EXTRA_LEGS_INDEX = "legs_index";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.master_list_button_next);
        button.setOnClickListener(buttonNextClicked());
    }

    private View.OnClickListener buttonNextClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AndroidMeActivity.class);
                intent.putExtra(EXTRA_HEAD_INDEX,mHeadIndex);
                intent.putExtra(EXTRA_BODY_INDEX,mBodyIndex);
                intent.putExtra(EXTRA_LEGS_INDEX,mLegsIndex);
                startActivity(intent);
            }
        };
    }


    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        int bodyPart = position/12;

        int positionPart = position - bodyPart*12;
        switch (bodyPart){
            case 0: {
                mHeadIndex = positionPart;
                break;
            }
            case 1: {
                mBodyIndex = positionPart;
                break;
            }
            case 2: {
                mLegsIndex = positionPart;
                break;
            }
        }

        // completed (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments

        // completed (3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity

        // completed (4) Get a reference to the "Next" button and launch the intent when this button is clicked

    }

}
