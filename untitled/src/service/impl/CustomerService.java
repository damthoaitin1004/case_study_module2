package service.impl;

import model.person.Customer;
import reponsitory.ICustomerRepository;
import reponsitory.imple.CustomerRepository;
import service.ICustomerService;
import untils.exception.Validate;

import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private final Scanner scanner = new Scanner(System.in);
    private final ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void displayAll() {
        List<Customer> customersDisplay = customerRepository.getCustomer();
        for (Customer c : customersDisplay) {
            System.out.println(c);
        }
    }

    @Override
    public void addCustomer() {
        boolean check;
        String enterCode;
        while (true) {
            System.out.println("Nhập mã khách hàng");
            enterCode = scanner.nextLine();
            check = Validate.checkStringIn(enterCode, "^KH-\\d{4}$");
            if (check) {
                if (customerRepository.getByCode(enterCode) == null) {
                    break;
                } else {
                    System.out.println("Mã khách hàng đã tồn tại vui lòng nhập lại");
                }

            } else {
                System.out.println("Sai định dạng vui lòng nhập lại");
            }
        }
        String enterName;
        while (true) {
            System.out.println("Nhập tên khách hàng");
            enterName = scanner.nextLine();
            check = Validate.checkStringIn(enterName, "^([A-Z]([a-z]+|)(\\s|$))+$");
            if (check) {
                break;
            } else {
                System.out.println("Sai định dạng vui lòng nhập lại");
            }
        }
        String enterBirth;
        while (true) {
            System.out.println("Nhập ngày tháng năm sinh");
            enterBirth = scanner.nextLine();
            check = Validate.checkStringIn(enterBirth, "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$");
            if (check) {
                break;
            } else {
                System.out.println("Sai định dạng vui lòng nhập lại");
            }
        }
        String enterGender;
        int chose;
        GEN:
        while (true) {
            try {
                System.out.println("Chọn giới tính cho khách hàng");
                System.out.println("1.Nam");
                System.out.println("2.Nữ");
                chose = Integer.parseInt(scanner.nextLine());
                switch (chose) {
                    case 1:
                        enterGender = "Nam";
                        break GEN;
                    case 2:
                        enterGender = "Nữ";
                        break GEN;
                    default:
                        System.out.println("Sai chức năng vui lòng chọn lại");
                }
            } catch (NumberFormatException n) {
                System.out.println("Người dùng nhập không phải số");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        String enterIdentityCard;
        while (true) {
            System.out.println("Nhập số CMND của khách hàng");
            enterIdentityCard = scanner.nextLine();
            check = Validate.checkStringIn(enterIdentityCard, "^\\d{9}$");
            boolean check2 = Validate.checkStringIn(enterIdentityCard, "^\\d{12}$");
            if ((check == true) || (check2 == true)) {
                break;
            } else {
                System.out.println("Nhập sai số CMND vui lòng nhập lại");
            }
        }
        String enterPhone;
        while (true) {
            System.out.println("Vui lòng nhập số điện thoại của khách hàng");
            enterPhone = scanner.nextLine();
            check = Validate.checkStringIn(enterPhone, "^0\\d{9}$");
            if (check) {
                break;
            } else {
                System.out.println("Nhập sai số điện thoại vui lòng nhập lại");
            }
        }
        String enterMail;
        while (true) {
            System.out.println("Nhập địa chỉ email của khách");
            enterMail = scanner.nextLine();
            check = Validate.checkStringIn(enterMail, "^(.+)@(\\S+)$");
            if (check) {
                break;
            } else {
                System.out.println("Sai định dạng vui lòng nhập lại");
            }
        }
        String enterCustomerTye;
        int choseNumber;
        CUSTYPE:
        while (true) {
            try {
                System.out.println("Chọn loại khách hàng");
                System.out.println("1.Diamond");
                System.out.println("2.Platinum");
                System.out.println("3.Gold");
                System.out.println("4.Silver");
                System.out.println("5.Member");
                choseNumber = Integer.parseInt(scanner.nextLine());
                switch (choseNumber) {
                    case 1:
                        enterCustomerTye = "Diamond";
                        break CUSTYPE;
                    case 2:
                        enterCustomerTye = "Platinum";
                        break CUSTYPE;
                    case 3:
                        enterCustomerTye = "Gold";
                        break CUSTYPE;
                    case 4:
                        enterCustomerTye = "Silver";
                        break CUSTYPE;
                    case 5:
                        enterCustomerTye = "Member";
                        break CUSTYPE;
                    default:
                        System.out.println("Sai chức năng vui lòng nhập lại");
                }
            } catch (NumberFormatException n) {
                System.out.println("Người nhập không phải số");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        System.out.println("Nhập địa chỉ khách hàng");
        String enterAddress = scanner.nextLine();
        Customer newCustomer = new Customer(enterCode, enterName, enterBirth, enterGender, enterIdentityCard, enterPhone, enterMail, enterCustomerTye, enterAddress);
        customerRepository.addCustomer(newCustomer);
    }

    @Override
    public void deleteCustomer() {
        DELE:
        while (true) {
            try {
                System.out.println("Nhập mã nhân viên cần xóa");
                String checkCode = scanner.nextLine();
                Customer customerDele = customerRepository.getByCode(checkCode);
                if (customerDele == null) {
                    System.out.println("Không tìm thâý nhân viên");
                    return;
                } else {
                    while (true) {
                        try {
                            System.out.println("Bạn có chắc chắn là muốn xóa nhân viên này không");
                            System.out.println("1.Xóa");
                            System.out.println("2.Suy nghĩ lại");
                            int chose = Integer.parseInt(scanner.nextLine());
                            if (chose == 1) {
                                customerRepository.removeCustomer(customerDele);
                                return;
                            } else if (chose == 2) {
                                return;
                            } else {
                                System.out.println("Sai chức năng vui lòng nhập lại");
                            }
                        } catch (NumberFormatException n) {
                            System.out.println("Người dùng nhập không phải số vui lòng nhập lại");
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
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
    public void settingCustomer() {
        customerRepository.editCustomer();
        Customer customerSet;
        while (true) {
            System.out.println("Nhập mã nhân viên cần chỉnh sửa");
            String checkCode = scanner.nextLine();
            customerSet = customerRepository.getByCode(checkCode);
            if (customerSet == null) {
                System.out.println("Mã nhân viên sai");
            } else {
                break;
            }
        }
        int enterChose;
        EDIT:
        while (true) {
            try {
                System.out.println("Sửa thông tin khách hàng "+customerSet.getCodePerson() + customerSet.getNamePerson());
                System.out.println("1.Sửa tên của khách hàng ");
                System.out.println("2.Sửa ngày sinh của khách hàng ");
                System.out.println("3.Sửa giới tính của khách hàng ");
                System.out.println("4.Sửa CMND của khách hàng");
                System.out.println("5.Sửa số điện thoại ");
                System.out.println("6.Sửa địa chỉ email của khách hàng");
                System.out.println("7.Sửa chế độ khách hàng");
                System.out.println("8.Sửa địa chỉ khách hàng");
                System.out.println("9.Quay lại");
                enterChose = Integer.parseInt(scanner.nextLine());
                switch (enterChose) {
                    case 1: {
                        CUSNAM:
                        while (true) {
                            System.out.println("Nhập tên khách hàng");
                            String newName = scanner.nextLine();
                            boolean checkName = Validate.checkStringIn(newName, "^([A-Z]([a-z]+|)(\\s|$))+$");
                            if (checkName) {
                                customerSet.setNamePerson(newName);
                                break CUSNAM;
                            } else {
                                System.out.println("Sai định dạng vui lòng nhập lại");
                            }
                        }
                    }
                    customerRepository.editUpFile();
                    break;
                    case 2: {
                        SETBIR:
                        while (true) {
                            System.out.println("Nhập ngày tháng năm sinh");
                            String newBirth = scanner.nextLine();
                            boolean check = Validate.checkStringIn(newBirth, "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$");
                            if (check) {
                                customerSet.setDateOfBirth(newBirth);
                                break SETBIR;
                            } else {
                                System.out.println("Sai định dạng vui lòng nhập lại");
                            }
                        }
                    }
                    customerRepository.editUpFile();
                    break;
                    case 3: {
                        EDITGEN:
                        while (true) {
                            try {
                                System.out.println("Chọn giới tính cho khách hàng");
                                System.out.println("1.Nam");
                                System.out.println("2.Nữ");
                                int chose = Integer.parseInt(scanner.nextLine());
                                switch (chose) {
                                    case 1:
                                        customerSet.setGender("Nam");
                                        break EDITGEN;
                                    case 2:
                                        customerSet.setGender("Nữ");
                                        break EDITGEN;
                                    default:
                                        System.out.println("Sai chức năng vui lòng chọn lại");
                                }
                            } catch (NumberFormatException n) {
                                System.out.println("Người dùng nhập không phải số");
                            } catch (Exception e) {
                                System.out.println("Error");
                            }
                        }
                    }
                    customerRepository.editUpFile();

                    break;
                    case 4: {
                        CMND:
                        while (true) {
                            System.out.println("Nhập số CMND của khách hàng");
                            String newIdentityCard = scanner.nextLine();
                            boolean check = Validate.checkStringIn(newIdentityCard, "^\\d{9}$");
                            boolean check2 = Validate.checkStringIn(newIdentityCard, "^\\d{12}$");
                            if ((check == true) || (check2 == true)) {
                                customerSet.setIdentityCard(newIdentityCard);
                                customerRepository.editUpFile();
                                break CMND;
                            } else {
                                System.out.println("Nhập sai số CMND vui lòng nhập lại");
                            }
                        }
                    }
                    customerRepository.editUpFile();
                    break;
                    case 5: {
                        PHONE:
                        while (true) {
                            System.out.println("Vui lòng nhập số điện thoại của khách hàng");
                            String newPhone = scanner.nextLine();
                            boolean check = Validate.checkStringIn(newPhone, "^0\\d{9}$");
                            if (check) {
                                customerSet.setPhoneNumber(newPhone);
                                break PHONE;
                            } else {
                                System.out.println("Nhập sai số điện thoại vui lòng nhập lại");
                            }
                        }
                    }
                    customerRepository.editUpFile();
                    break;
                    case 6: {
                        EMAIL:
                        while (true) {
                            System.out.println("Nhập địa chỉ email của khách");
                            String newMail = scanner.nextLine();
                            boolean check = Validate.checkStringIn(newMail, "^(.+)@(\\S+)$");
                            if (check) {
                                customerSet.setEmail(newMail);
                                break EMAIL;
                            } else {
                                System.out.println("Sai định dạng vui lòng nhập lại");
                            }
                        }
                    }
                    customerRepository.editUpFile();

                    break;
                    case 7: {
                        EDITTY:
                        while (true) {
                            try {
                                System.out.println("Chọn loại khách hàng");
                                System.out.println("1.Diamond");
                                System.out.println("2.Platinum");
                                System.out.println("3.Gold");
                                System.out.println("4.Silver");
                                System.out.println("5.Member");
                                int choseNumber = Integer.parseInt(scanner.nextLine());
                                switch (choseNumber) {
                                    case 1:
                                        customerSet.setCustomerType("Diamond");


                                        break EDITTY;

                                    case 2:
                                        customerSet.setCustomerType("Platinum");

                                        break EDITTY;
                                    case 3:
                                        customerSet.setCustomerType("Gold");


                                        break EDITTY;
                                    case 4:
                                        customerSet.setCustomerType("Silver");


                                        break EDITTY;
                                    case 5:
                                        customerSet.setCustomerType("Member");


                                        break EDITTY;
                                    default:
                                        System.out.println("Sai chức năng vui lòng nhập lại");
                                }
                            } catch (NumberFormatException n) {
                                System.out.println("Người nhập không phải số");
                            } catch (Exception e) {
                                System.out.println("Error");
                            }
                        }
                    }
                    customerRepository.editUpFile();

                    break;
                    case 8: {
                        System.out.println("Nhập địa chỉ khách hàng");
                        String newAddress = scanner.nextLine();
                        customerSet.setAddress(newAddress);
                        customerRepository.editUpFile();
                    }
                    break;
                    case 9:
                        break EDIT;
                    default:
                        System.out.println("Nhập sai chức năng vui lòng nhập lại");
                }
            } catch (NumberFormatException n) {
                System.out.println("Người dùng nhập không phải số");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }

    }

    @Override
    public void searchCustomer() {
        System.out.println("Nhập từ khóa tìm kiếm");
        String searchName = scanner.nextLine();
        List<Customer> customerSearch = customerRepository.searchCustomer(searchName);
        if (customerSearch == null) {
            System.out.println("Không tìm thấy kết quả ");
        } else {
            for (Customer c : customerSearch) {
                System.out.println(c);
            }
        }
    }
}
