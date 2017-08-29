package com.app.jobschedulersexample;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final int MY_JOB_ID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStart = (Button)findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scheduleJob(view.getContext());

            }
        });

    }

    public static void scheduleJob(Context context) {
        ComponentName serviceComponent = new ComponentName(context,MyJobService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            JobInfo.Builder jobInfo = new JobInfo.Builder(MY_JOB_ID,serviceComponent);
            jobInfo.setMinimumLatency(1 * 1000);
            jobInfo.setOverrideDeadline(3 * 1000);
            jobInfo.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
            jobInfo.setRequiresCharging(true);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                jobInfo.setRequiresBatteryNotLow(true);
            }
            jobInfo.setRequiresDeviceIdle(false);

            JobScheduler jobScheduler = (JobScheduler) context.
                    getSystemService(JOB_SCHEDULER_SERVICE);

            jobScheduler.schedule(jobInfo.build());

        }
    }
}
