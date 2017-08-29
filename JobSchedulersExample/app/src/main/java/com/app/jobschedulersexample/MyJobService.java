package com.app.jobschedulersexample;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

/**
 * Created by iSaleem on 8/29/17.
 */

public class MyJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Toast.makeText(this, "Working", Toast.LENGTH_SHORT).show();

        return false;
    }


    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
