public class main {
    public static void main(String[] args) {
        TriageType doctorTriageType = TriageType.FIFO;
        TriageType radiologyTriageType = TriageType.FIFO;

        Clinic clinic = new Clinic(doctorTriageType, radiologyTriageType);
        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);

        System.out.println("Test");
    }
}
