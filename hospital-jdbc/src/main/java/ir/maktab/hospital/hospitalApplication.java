package ir.maktab.hospital;

import ir.maktab.hospital.entity.DoctorEntity;
import ir.maktab.hospital.entity.PatientEntity;
import ir.maktab.hospital.service.DoctorService;
import ir.maktab.hospital.service.PatientService;

public class hospitalApplication {

    private static final PatientService PATIENT_SERVICE = new PatientService();
    private static final DoctorService DOCTOR_SERVICE = new DoctorService();

    public static void main(String[] args) {

        //======Set your Config in DbConfig======

        PatientEntity patient = new PatientEntity("ahwaz", "ali", 18, "2000-09-28", "male");
        PATIENT_SERVICE.save(patient);
        PatientEntity loadPatient = PATIENT_SERVICE.findById(1);

        DoctorEntity doctor = new DoctorEntity(1, "reza ", "eye", "seniority");
        DOCTOR_SERVICE.save(doctor);
        DoctorEntity byId = DOCTOR_SERVICE.findById(1);
        System.out.println(byId);

        System.out.println(loadPatient);

    }

}
