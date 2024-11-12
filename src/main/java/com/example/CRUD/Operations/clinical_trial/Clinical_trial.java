package com.example.CRUD.Operations.clinical_trial;

public class Clinical_trial {
    private String id;
    private String title;
    private String status;
    private String minimumAge;
    private String maximunAge;
    private String startDate;
    private String endDate;
    private String participantCount;

    @Override
    public String toString() {
        return "Clinical_trial{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", minimumAge='" + minimumAge + '\'' +
                ", maximunAge='" + maximunAge + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", participantCount='" + participantCount + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(String minimumAge) {
        this.minimumAge = minimumAge;
    }

    public String getMaximunAge() {
        return maximunAge;
    }

    public void setMaximunAge(String maximunAge) {
        this.maximunAge = maximunAge;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(String participantCount) {
        this.participantCount = participantCount;
    }

    public Clinical_trial(String id, String title, String status, String minimumAge, String maximumAge, String startDate, String endDate, String participantCount) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.minimumAge = minimumAge;
        this.maximunAge = maximumAge;
        this.startDate = startDate;
        this.endDate = endDate;
        this.participantCount = participantCount;
    }



}
