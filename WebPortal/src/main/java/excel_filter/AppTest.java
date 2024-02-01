package excel_filter;

public class AppTest {
    private int S_no;
    private String reference;
    private String initiationDate;
    private String initiatorName;
    private String initiatorDepartment;
    private String initiatorLocation;
    private String pendingUser;
    private String pendingDepartment;
    private String pendingLocation;
    private String Subject;
    private int pendingDays;

    public AppTest(int S_no, String refernce, String initiationDate, String initiatorName, String initiatorDepartment, String initiatorLocation, String pendingUser, String pendingDepartment, String pendingLocation, String Subject, int pendingDays) {
        this.S_no = S_no;
        this.reference = refernce;
        this.initiationDate = initiationDate;
        this.initiatorName = initiatorName;
        this.initiatorDepartment = initiatorDepartment;
        this.initiatorLocation = initiatorLocation;
        this.pendingUser = pendingUser;
        this.pendingDepartment = pendingDepartment;
        this.pendingLocation = pendingLocation;
        this.Subject = Subject;
        this.pendingDays = pendingDays;
    }

    @Override
    public String toString() {
        return "FetchData [S_no=" + S_no + ", refernce=" + reference + ", initiationDate=" + initiationDate
                + ", initiatorName=" + initiatorName + ", initiatorDepartment=" + initiatorDepartment
                + ", initiatorLocation=" + initiatorLocation + ", pendingUser=" + pendingUser
                + ", pendingDepartment=" + pendingDepartment + ", pendingLocation=" + pendingLocation
                + ", Subject=" + Subject + ", pendingDays=" + pendingDays + "]";
    }

    public int getS_no() {
        return S_no;
    }

    public void setS_no(int S_no) {
        this.S_no = S_no;
    }

    public String getRefernce() {
        return reference;
    }

    public void setRefernce(String refernce) {
        this.reference = refernce;
    }

    public String getInitiationDate() {
        return initiationDate;
    }

    public void setInitiationDate(String initiationDate) {
        this.initiationDate = initiationDate;
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    public String getInitiatorDepartment() {
        return initiatorDepartment;
    }

    public void setInitiatorDepartment(String initiatorDepartment) {
        this.initiatorDepartment = initiatorDepartment;
    }

    public String getInitiatorLocation() {
        return initiatorLocation;
    }

    public void setInitiatorLocation(String initiatorLocation) {
        this.initiatorLocation = initiatorLocation;
    }

    public String getPendingUser() {
        return pendingUser;
    }

    public void setPendingUser(String pendingUser) {
        this.pendingUser = pendingUser;
    }

    public String getPendingDepartment() {
        return pendingDepartment;
    }

    public void setPendingDepartment(String pendingDepartment) {
        this.pendingDepartment = pendingDepartment;
    }

    public String getPendingLocation() {
        return pendingLocation;
    }

    public void setPendingLocation(String pendingLocation) {
        this.pendingLocation = pendingLocation;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public int getPendingDays() {
        return pendingDays;
    }

    public void setPendingDays(int pendingDays) {
        this.pendingDays = pendingDays;
    }
}
