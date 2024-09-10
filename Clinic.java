import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Clinic {
    TriageType doctorTriageType;
    TriageType radiologyTriageType;
    FifoQueue fileAttenteMedecin = new FifoQueue();
    FifoQueue fileAttenteRadiologie = new FifoQueue();

    public Clinic(TriageType doctorTriageType, TriageType radiologyTriageType) {
        this.doctorTriageType = doctorTriageType;
        this.radiologyTriageType = radiologyTriageType;
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient patient = new Patient(name, gravity, visibleSymptom);

        if (visibleSymptom == VisibleSymptom.MIGRAINE) {

            if (doctorTriageType == TriageType.FIFO) {
                fileAttenteMedecin.addAtBeginning(patient);
            } else if (doctorTriageType == TriageType.GRAVITY) {
                //
            }

        } else if (visibleSymptom == VisibleSymptom.FLU) {

            if (doctorTriageType == TriageType.FIFO) {
                fileAttenteMedecin.add(patient);
            } else triageTypeGravityCheck(gravity, patient);

        } else if (visibleSymptom == VisibleSymptom.SPRAIN) {

            if (doctorTriageType == TriageType.FIFO) {
                fileAttenteMedecin.addAtBeginning(patient);

                if (fileAttenteRadiologie.isEmpty()) {
                    fileAttenteRadiologie.addAtBeginning(patient);
                } else {
                    Patient firstPatient = fileAttenteRadiologie.getFirstPatient();
                    if (firstPatient.gravity() < gravity) {
                        fileAttenteRadiologie.addAtBeginning(patient);
                    } else {
                        fileAttenteRadiologie.add(patient);
                    }
                }

                fileAttenteRadiologie.addAtBeginning(patient);
            } else if (doctorTriageType == TriageType.GRAVITY) {
                //
            }

        } else if (visibleSymptom == VisibleSymptom.BROKEN_BONE) {
            if (doctorTriageType == TriageType.FIFO) {
                //
            } else {
                if ((!fileAttenteMedecin.isEmpty() && !fileAttenteRadiologie.isEmpty())
                        && doctorTriageType == TriageType.GRAVITY && radiologyTriageType == TriageType.GRAVITY) {
                    Patient firstPatient = fileAttenteRadiologie.getFirstPatient();
                    if (firstPatient.gravity() < gravity) {
                        fileAttenteRadiologie.addAtBeginning(patient);
                    } else {
                        fileAttenteRadiologie.add(patient);
                    }
                } else {
                    //fileAttenteRadiologie.add(patient);
                }

                triageTypeGravityCheck(gravity, patient);
            }
        }
    }

    private void triageTypeGravityCheck(int gravity, Patient patient) {
        if (doctorTriageType == TriageType.GRAVITY) {
            if (fileAttenteMedecin.isEmpty()) {
                fileAttenteMedecin.add(patient);
            } else {
                Patient firstPatient = fileAttenteMedecin.getFirstPatient();
                if (firstPatient.gravity() < gravity) {
                    fileAttenteMedecin.addAtBeginning(patient);
                } else {
                    fileAttenteMedecin.add(patient);
                }
            }
        }
    }
}
