/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2020 DBeaver Corp and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.model.task;

import org.jkiss.code.NotNull;
import org.jkiss.code.Nullable;
import org.jkiss.dbeaver.DBException;
import org.jkiss.dbeaver.model.runtime.DBRProgressMonitor;

import java.util.Collection;
import java.util.List;

/**
 * Scheduler
 */
public interface DBTScheduler {
    String FEATURE_START_TIME = "startTime";
    String FEATURE_FREQUENCY_MINUTELY = "frequency.minutely";
    String FEATURE_FREQUENCY_MINUTELY_START_DATETIME = FEATURE_FREQUENCY_MINUTELY + "start_datetime";
    String FEATURE_FREQUENCY_HOURLY = "frequency.hourly";
    String FEATURE_FREQUENCY_HOURLY_START_DATETIME = FEATURE_FREQUENCY_HOURLY + "start_datetime";
    String FEATURE_FREQUENCY_DAILY = "frequency.daily";
    String FEATURE_FREQUENCY_DAILY_START_DATE = "frequency.daily.start_date";
    String FEATURE_FREQUENCY_WEEKLY = "frequency.weekly";
    String FEATURE_FREQUENCY_WEEKLY_START_DATE = FEATURE_FREQUENCY_WEEKLY + ".start_date";
    String FEATURE_FREQUENCY_MONTHLY = "frequency.monthly";
    String FEATURE_FREQUENCY_MONTHLY_START_DATE = FEATURE_FREQUENCY_MONTHLY + ".start_date";
    String FEATURE_FREQUENCY_ONETIME = "frequency.onetime";
    String FEATURE_FREQUENCY_ONETIME_START_DATETIME = "frequency.onetime.start_datetime";
    String FEATURE_FREQUENCY_EVENT = "frequency.event";
    String FEATURE_FREQUENCY_WEEKLY_RECURRENCE = FEATURE_FREQUENCY_WEEKLY + ".recurrence";
    String FEATURE_FREQUENCY_MONTHLY_LAST_DAY = FEATURE_FREQUENCY_MONTHLY + ".last_day";
    String FEATURE_FREQUENCY_HOURLY_RECURRENCE_GREATER_THAN_23 = FEATURE_FREQUENCY_HOURLY + ".recurrence.greater_than_23";
    String FEATURE_FREQUENCY_MINUTELY_RECURRENCE_GREATER_THAN_59 = FEATURE_FREQUENCY_MINUTELY + ".recurrence.greater_than_59";
    String FEATURE_FREQUENCY_MINUTELY_RECURRENCE_GREATER_THAN_31 = FEATURE_FREQUENCY_DAILY + ".recurrence.greater_than_31";

    @NotNull
    String getSchedulerName();

    Collection<String> getSchedulerSupportedFeatures();

    @NotNull
    List<DBTTaskScheduleInfo> getAllScheduledTasks();

    @Nullable
    DBTTaskScheduleInfo getScheduledTaskInfo(@NotNull DBTTask task);

    @Nullable
    DBTTaskScheduleConfiguration getScheduledTaskConfiguration(@NotNull DBTTask task) throws DBException;

    void setTaskSchedule(@NotNull DBTTask task, @NotNull DBTTaskScheduleConfiguration scheduleConfiguration) throws DBException;

    void removeTaskSchedule(@NotNull DBTTask task, DBTTaskScheduleInfo scheduleInfo) throws DBException;

    void refreshScheduledTasks(@NotNull DBRProgressMonitor monitor) throws DBException;

    /**
     * Opens scheduler settings.
     * @return settings information to show in DBeaver UI. Null if scheduler uses some proprietary way to show settings.
     */
    @Nullable
    DBTSchedulerExternalSettings openSchedulerSettings() throws DBException;

}
