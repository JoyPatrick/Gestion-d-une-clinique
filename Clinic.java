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
                // Gravity algo
            }

        } else if (visibleSymptom == VisibleSymptom.FLU) {

            if (doctorTriageType == TriageType.FIFO) {
                fileAttenteMedecin.add(patient);
            } else if (doctorTriageType == TriageType.GRAVITY) {
                if (gravity > 7) {
                    fileAttenteMedecin.addAtBeginning(patient);
                }
            }

        } else if (visibleSymptom == VisibleSymptom.SPRAIN) {

            if (doctorTriageType == TriageType.FIFO) {
                fileAttenteMedecin.addAtBeginning(patient);
                fileAttenteRadiologie.addAtBeginning(patient);
            } else if (doctorTriageType == TriageType.GRAVITY) {
                //
            }

        } else if (visibleSymptom == VisibleSymptom.BROKEN_BONE) {
            if (doctorTriageType == TriageType.FIFO) {
                //
            } else if (doctorTriageType == TriageType.GRAVITY) {
                if (gravity > 7) {
                    fileAttenteMedecin.addAtBeginning(patient);
                }
            }
        }
    }



    // D'autres méthodes peuvent être nécessaires

}
