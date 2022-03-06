package ir.maktab.presentation.cmd;

import ir.maktab.entity.Major;
import ir.maktab.entity.Student;
import ir.maktab.presentation.ui.Input;
import ir.maktab.service.MajorService;
import ir.maktab.service.StudentService;

public class SignUpCmd implements MenuCommand {

    private final StudentService studentService = new StudentService();
    private final MajorService majorService = new MajorService();

    @Override
    public int select() {
        return 1;
    }

    @Override
    public void execute() {
        studentService.saveOrUpdate(SignUpStudent());
    }

    public Student SignUpStudent() {
        System.out.println("=== Sign up ===");
        System.out.println("Enter your name : ");
        String name = Input.getString();
        System.out.print("Enter your family : ");
        String family = Input.getString();
        System.out.println("Choose your major : ");
        System.out.println(majorService.loadAll());
        System.out.println("Enter major id : ");
        int majorId = Input.getInt();
        return Student.builder(new Major(majorId))
                .name(name)
                .familyName(family)
                .build();
    }

}
