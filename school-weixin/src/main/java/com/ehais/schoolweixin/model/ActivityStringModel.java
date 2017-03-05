package com.ehais.schoolweixin.model;



//作为活动表单对象的接收参数
public class ActivityStringModel {
	    private String id;
	    
	    private String pCount;

		private String activityName;

	    private String description;

	    private String startTime;

	    private String endTime;

	    private String finalTime;
	    
	    public ActivityStringModel() {
	    	
	    }
	    public ActivityStringModel( String activityName, String pCount, String startTime, String endTime, String finalTime) {
			this.activityName = activityName;
			this.pCount = pCount;
			this.startTime = startTime;
			this.endTime = endTime;
			this.finalTime = finalTime;
		}

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getActivityName() {
	        return activityName;
	    }

	    public void setActivityName(String activityName) {
	        this.activityName = activityName == null ? null : activityName.trim();
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getStartTime() {
	        return startTime;
	    }

	    public void setStartTime(String startTime) {
	        this.startTime = startTime;
	    }
	    
	    public String getpCount() {
			return pCount;
		}
		public void setpCount(String pCount) {
			this.pCount = pCount;
		}

	    public String getEndTime() {
	        return endTime;
	    }

	    public void setEndTime(String endTime) {
	        this.endTime = endTime;
	    }

	    public String getFinalTime() {
	        return finalTime;
	    }

	    public void setFinalTime(String finalTime) {
	        this.finalTime = finalTime;
	    }
	    
	    public String toString() {
	    	return this.activityName + "\n"
	    			+ this.description + "\n" 
	    			+ this.startTime + "\n"
	    			+ this.endTime + "\n"
	    			+ this.finalTime + "\n"
	    			+ this.pCount + "\n"
	    			+ this.id + "\n";
	    }
	}
