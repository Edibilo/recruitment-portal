package iki.mashad.dto;

public class DashboardDto {
    private int totalUser;
    private int totalRecruiter;
    private int totalApplicant;
    private int totalAdmin;
    private int totalJob;
    private int totalApplication;
    private int pendingApplication;
    private int inProgressApplication;
    private int rejectApplication;
    private int successApplication;

    public DashboardDto(int totalUser, int totalRecruiter, int totalApplicant, int totalAdmin,
                        int totalJob, int totalApplication, int pendingApplication,
                        int inProgressApplication, int rejectApplication, int successApplication) {
        this.totalUser = totalUser;
        this.totalRecruiter = totalRecruiter;
        this.totalApplicant = totalApplicant;
        this.totalAdmin = totalAdmin;
        this.totalJob = totalJob;
        this.totalApplication = totalApplication;
        this.pendingApplication = pendingApplication;
        this.inProgressApplication = inProgressApplication;
        this.rejectApplication = rejectApplication;
        this.successApplication = successApplication;
    }

    public int getTotalAdmin() {
        return totalAdmin;
    }

    public void setTotalAdmin(int totalAdmin) {
        this.totalAdmin = totalAdmin;
    }

    public DashboardDto(){

    }

    public int getTotalUser() {
        return totalUser;
    }

    public void setTotalUser(int totalUser) {
        this.totalUser = totalUser;
    }

    public int getTotalRecruiter() {
        return totalRecruiter;
    }

    public void setTotalRecruiter(int totalRecruiter) {
        this.totalRecruiter = totalRecruiter;
    }

    public int getTotalApplicant() {
        return totalApplicant;
    }

    public void setTotalApplicant(int totalApplicant) {
        this.totalApplicant = totalApplicant;
    }

    public int getTotalJob() {
        return totalJob;
    }

    public void setTotalJob(int totalJob) {
        this.totalJob = totalJob;
    }

    public int getTotalApplication() {
        return totalApplication;
    }

    public void setTotalApplication(int totalApplication) {
        this.totalApplication = totalApplication;
    }

    public int getPendingApplication() {
        return pendingApplication;
    }

    public void setPendingApplication(int pendingApplication) {
        this.pendingApplication = pendingApplication;
    }

    public int getInProgressApplication() {
        return inProgressApplication;
    }

    public void setInProgressApplication(int inProgressApplication) {
        this.inProgressApplication = inProgressApplication;
    }

    public int getRejectApplication() {
        return rejectApplication;
    }

    public void setRejectApplication(int rejectApplication) {
        this.rejectApplication = rejectApplication;
    }

    public int getSuccessApplication() {
        return successApplication;
    }

    public void setSuccessApplication(int successApplication) {
        this.successApplication = successApplication;
    }
}
