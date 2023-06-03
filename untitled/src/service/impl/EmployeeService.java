package service.impl;

import model.person.Employee;
import model.person.Person;
import reponsitory.IEmployeeRepository;
import reponsitory.imple.EmployeeRepository;
import service.IEmployeeService;
import untils.exception.Validate;

import java.util.List;
import java.util.Scanner;

//    String codePerson, String namePerson, String dateOfBirth, String gender, int identityCard, int phoneNumber, String email, String level, String position, float salary
public class EmployeeService implements IEmployeeService {
    private Scanner scanner = new Scanner(System.in);
    private IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public void displayAll() {
        List<Employee> person = employeeRepository.getEmployeeList();
        for (Employee e : person) {
            System.out.println(e);
        }
    }

    @Override
    public void addEmployee() {
        String enterCode;
        CODE:
        while (true) {
            System.out.println("Nhập mã nhân viên");
            enterCode = scanner.nextLine();
            boolean check = Validate.checkStringIn(enterCode, "^NV-\\d{4}$");
            if (check) {
                if (employeeRepository.getByCode(enterCode) == null) {
                    break CODE;
                } else {
                    System.out.println("Mã nhân viên đã tồn tại");
                }
            } else {
                System.out.println("Mã nhân viên phải nhập theo định dạng");
            }
        }
        String enterName;
        while (true) {
            System.out.println("Nhập tên nhân viên");
            enterName = scanner.nextLine();
            boolean check = Validate.checkStringIn(enterName, "^(([A-Z])(([a-z]+)|)(\\s|$))+");
            if (check) {
                break;
            } else {
                System.out.println("Sai định dạng tên vui lòng nhập lại");
            }
        }
        String enterDateBirth;
        while (true) {
            System.out.println("Nhập ngày tháng năm sinh của nhân viên");
            enterDateBirth = scanner.nextLine();
            boolean check = Validate.checkStringIn(enterDateBirth, "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$");
            if (check) {
                break;
            } else {
                System.out.println("Nhập sai vui lòng nhập lại");
            }
        }

        int choseGender;
        String enterGender;
        GEN:
        while (true) {
            try {
                System.out.println("Nhập giới tính cho nhân viên");
                System.out.println("1.Nam");
                System.out.println("2.Nữ");
                choseGender = Integer.parseInt(scanner.nextLine());
                switch (choseGender) {
                    case 1:
                        enterGender = "Nam";
                        break GEN;
                    case 2:
                        enterGender = "Nữ";
                        break GEN;
                    default:
                        System.out.println("Sai chức năng vui lòng nhập lại");
                        break;

                }
            } catch (NumberFormatException n) {
                System.out.println("Người dùng nhập không phải số vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Error");
            }

        }
        String enterIdentityCard;
        while (true) {
            System.out.println("Nhập số chứng minh nhân viên");
            enterIdentityCard = scanner.nextLine();
            boolean check1 = Validate.checkStringIn(enterIdentityCard, "^\\d{9}$");
            boolean check2 = Validate.checkStringIn(enterIdentityCard, "^\\d{12}$");
            if ((check1 == true) || (check2 == true)) {
                break;
            } else {
                System.out.println("Sai CMND vui lòng nhập lại");
            }
        }

        String enterPhone;
        while (true) {
            System.out.println("Nhập số điện thoại của nhân viên");
            enterPhone = scanner.nextLine();
            boolean check = Validate.checkStringIn(enterPhone, "^0\\d{9}$");
            if (check) {
                break;
            } else {
                System.out.println("Số điện thoại phải đủ 10 số bắt đầu bằng số 0 đầu vui lòng nhập lại");
            }
        }
        String enterEmail;
        while (true) {
            System.out.println("Nhập địa chỉ email của nhân viên");
            enterEmail = scanner.nextLine();
            boolean check = Validate.checkStringIn(enterEmail, "^(.+)@(\\S+)$");
            if (check) {
                break;
            } else {
                System.out.println("Nhập sai định dạng vui lòng nhập lại");
            }
        }

        int choseLevel;
        String enterLevel;
        LV:
        while (true) {
            try {
                System.out.println("Nhập trình độ cho nhân viên");
                System.out.println("1.Đại học");
                System.out.println("2.Cao đẳng");
                System.out.println("3.Trung cấp");
                System.out.println("4.Sau đại học");
                choseLevel = Integer.parseInt(scanner.nextLine());
                switch (choseLevel) {
                    case 1:
                        enterLevel = "Đại học";
                        break LV;
                    case 2:
                        enterLevel = "Cao đẳng";
                        break LV;
                    case 3:
                        enterLevel = "Trung cấp";
                        break LV;
                    case 4:
                        enterLevel = "Sau đại học";
                        break LV;
                    default:
                        System.out.println("Sai chức năng vui lòng nhập lại");
                        break;
                }
            } catch (NumberFormatException n) {
                System.out.println("Người dùng nhập không phải số");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        String enterPosition;
        int chosePosition;
        POI:
        while (true) {
            try {
                System.out.println("Nhập trình vị trí cho nhân viên ");
                System.out.println("1.Lễ tân");
                System.out.println("2.Phục vụ");
                System.out.println("3.Chuyên viên");
                System.out.println("4.Giám sát");
                System.out.println("5.Quản lí");
                System.out.println("6.Giám đốc");
                chosePosition = Integer.parseInt(scanner.nextLine());
                switch (chosePosition) {
                    case 1:
                        enterPosition = "Lễ tân";
                        break POI;
                    case 2:
                        enterPosition = "Phục vụ";
                        break POI;
                    case 3:
                        enterPosition = "Chuyên viên";
                        break POI;
                    case 4:
                        enterPosition = "Giám sát";
                        break POI;
                    case 5:
                        enterPosition = "Quản lí";
                        break POI;
                    case 6:
                        enterPosition = "Giám đốc";
                        break POI;
                    default:
                        System.out.println("Sai chức năng vui lòng nhập lại");
                        break;
                }
            } catch (NumberFormatException n) {
                System.out.println("Người dùng nhập không phải số vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }

        float enterSalary;
        while (true) {
            try {
                System.out.println("Nhập lương cho nhân viên");
                enterSalary = Float.parseFloat(scanner.nextLine());
                if (enterSalary > 0) {
                    break;
                } else {
                    System.out.println("Nhập sai lương vui lòng nhập lại");
                }
            } catch (NumberFormatException n) {
                System.out.println("Nhập sai định dạng");
            } catch (Exception e) {
                System.out.println("Error");
            }

        }


        Employee newEmployee = new Employee(enterCode, enterName, enterDateBirth, enterGender, enterIdentityCard, enterPhone, enterEmail, enterLevel, enterPosition, enterSalary);
        employeeRepository.addEmployee(newEmployee);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void deleteEmployee() {
        while (true) {
            try {
                System.out.println("Nhập mã nhân viên cần xóa");
                String checkCode = scanner.nextLine();
                Person employeeDele = employeeRepository.getByCode(checkCode);
                if (employeeDele == null) {
                    System.out.println("Không tìm thâý nhân viên");
                } else {
                    System.out.println("Bạn có chắc chắn là muốn xóa nhân viên này không");
                    System.out.println("1.Xóa");
                    System.out.println("2.Suy nghĩ lại");
                    int chose = Integer.parseInt(scanner.nextLine());
                    if (chose == 1) {
                        employeeRepository.removeEmployee((Employee) employeeDele);
                        break;
                    } else if (chose == 2) {
                        break;
                    } else {
                        System.out.println("Sai chức năng vui lòng nhập lại");
                    }
                }
            } catch (NumberFormatException n) {
                System.out.println("Người dùng nhập không phải số");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }

    }

    @Override
    public void settingEmployee() {
        employeeRepository.editEmployee();
        Employee employeedit;
        while (true) {
            System.out.println("Nhập mã nhân viên cần chỉnh sửa");
            String checkCode = scanner.nextLine();
            employeedit = employeeRepository.getByCode(checkCode);
            if (employeedit == null) {
                System.out.println("Mã nhân viên sai");
            } else {
                break;
            }
        }
        int chose;
        EDIT:
        while (true) {
            System.out.println("Chỉnh sửa thông tin ");
            System.out.println("1.Chỉnh sửa tên ");
            System.out.println("2.Chỉnh sửa ngày sinh ");
            System.out.println("3.Chỉnh sửa số điện thoại");
            System.out.println("4.Chỉnh sửa email");
            System.out.println("5.Chỉnh sửa lương nhân viên");
            System.out.println("6.Chỉnh sửa chức vụ");
            System.out.println("0.Quay lại Employee menu");
            chose = Integer.parseInt(scanner.nextLine());
            switch (chose) {
                case 1: {
                    String newName;
                    NAME:
                    while (true) {
                        System.out.println("Nhập tên nhân viên");
                        newName = scanner.nextLine();
                        boolean check = Validate.checkStringIn(newName, "^(([A-Z])(([a-z]+)|)(\\s|$))+");
                        if (check) {
                            break NAME;
                        } else {
                            System.out.println("Sai định dạng tên vui lòng nhập lại");
                        }
                    }
                    employeedit.setNamePerson(newName);
                }
                employeeRepository.editUpFile();
                break;
                case 2: {
                    String newDateBirth;
                    EDITBRTH:
                    while (true) {
                        System.out.println("Nhập ngày tháng năm sinh của nhân viên");
                        newDateBirth = scanner.nextLine();
                        boolean check = Validate.checkStringIn(newDateBirth, "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$");
                        if (check) {
                            break EDITBRTH;
                        } else {
                            System.out.println("Nhập sai vui lòng nhập lại");
                        }
                    }
                    employeedit.setDateOfBirth(newDateBirth);
                }
                employeeRepository.editUpFile();
                break;
                case 3: {
                    String newPhone;
                    EDITPHO:
                    while (true) {
                        System.out.println("Nhập số điện thoại của nhân viên");
                        newPhone = scanner.nextLine();
                        boolean check = Validate.checkStringIn(newPhone, "^0\\d{9}$");
                        if (check) {
                            break EDITPHO;
                        } else {
                            System.out.println("Số điện thoại phải đủ 10 số bắt đầu bằng số 0 đầu vui lòng nhập lại");
                        }
                    }
                    employeedit.setPhoneNumber(newPhone);
                }
                employeeRepository.editUpFile();
                break;
                case 4: {
                    String newEmail;
                    EMALL:
                    while (true) {
                        System.out.println("Nhập email của nhân viên");
                        newEmail = scanner.nextLine();
                        employeedit.setEmail(newEmail);
                        boolean check = Validate.checkStringIn(newEmail, "^(.+)@(\\\\S+)$");
                        if (check) {
                            break EMALL;
                        } else {
                            System.out.println("Nhập sai định dạng vui lòng nhập lại");
                        }
                    }
                }
                employeeRepository.editUpFile();
                break;

                case 5: {
                    float newSalary;
                    while (true) {
                        System.out.println("Nhập lương cho nhân viên");
                        newSalary = Float.parseFloat(scanner.nextLine());
                        if (newSalary > 0) {
                            break;
                        } else {
                            System.out.println("Nhập sai lương vui lòng nhập lại");
                        }
                    }
                    employeedit.setSalary(newSalary);
                }
                employeeRepository.editUpFile();
                break;
                case 6: {
                    String newPosition;
                    int chosePosition;
                    POI:
                    EDITPOS:
                    while (true) {
                        try {
                            System.out.println("Nhập trình vị trí cho nhân viên ");
                            System.out.println("1.Lễ tân");
                            System.out.println("2.Phục vụ");
                            System.out.println("3.Chuyên viên");
                            System.out.println("4.Giám sát");
                            System.out.println("5.Quản lí");
                            System.out.println("6.Giám đốc");
                            chosePosition = Integer.parseInt(scanner.nextLine());
                            switch (chosePosition) {
                                case 1:
                                    newPosition = "Lễ tân";
                                    break EDITPOS;
                                case 2:
                                    newPosition = "Phục vụ";
                                    break EDITPOS;
                                case 3:
                                    newPosition = "Chuyên viên";
                                    break EDITPOS;
                                case 4:
                                    newPosition = "Giám sát";
                                    break EDITPOS;
                                case 5:
                                    newPosition = "Quản lí";
                                    break EDITPOS;
                                case 6:
                                    newPosition = "Giám đốc";
                                    break EDITPOS;
                                default:
                                    System.out.println("Sai chức năng vui lòng nhập lại");
                                    break;
                            }
                        } catch (NumberFormatException n) {
                            System.out.println("Người dùng nhập không phải số vui lòng nhập lại");
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
                    }
                }
                employeeRepository.editUpFile();
                break;
                case 0:
                    break EDIT;
                default:
                    System.out.println("Sai chức năng vui lòng nhập lại");
            }
        }
    }

    @Override
    public void searchEmployee() {
        System.out.println("Nhập tên nhân viên cần tìm");
        String nameSearch = scanner.nextLine();
        List<Employee> employeesSearch = employeeRepository.searchEmployee(nameSearch);
        for (Employee e : employeesSearch) {
            System.out.println(e);
        }
    }
}
