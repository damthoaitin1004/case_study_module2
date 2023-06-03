package service.impl;

import model.fancility.Facility;
import model.fancility.Room;
import reponsitory.IFacilityRepository;
import reponsitory.imple.FacilityRepository;
import service.IFacilityService;
import untils.exception.Validate;

import java.util.Scanner;

public class RoomService  {
    private static  final Scanner scanner = new Scanner(System.in);
    private static final IFacilityRepository facilityRepository = new FacilityRepository();


    public static void addFacility() {
        String enterCode;
        while (true) {
            System.out.println("Nhập mã dịch vụ");
            enterCode = scanner.nextLine();
            boolean check = Validate.checkStringIn(enterCode, "^SVRO-\\d{4}$");
            if (check) {
                if (facilityRepository.getByCode(enterCode) != null) {
                    System.out.println("Mã dịch vụ đã tồn tại vui lòng nhập lại");
                } else {
                    break;
                }
            } else {
                System.out.println("Sai định dạng vui lòng nhập lại");
            }
        }
        String enterName;
        while (true) {
            System.out.println("Nhập tên cho dịch vụ Room ");
            enterName = scanner.nextLine();
            boolean check = Validate.checkStringIn(enterName, "^[A-Z].+$");
            if (check) {
                break;
            } else {
                System.out.println("Sai định dạng vui lòng nhập lại");
            }
        }
        float enterArea;
        while (true) {
            try {
                System.out.println("Nhập diện tích sử dụng của dịch vụ");
                enterArea = Float.parseFloat(scanner.nextLine());
                if (enterArea > 30) {
                    break;
                } else {
                    System.out.println("Nhập sai vui lòng nhập lại");
                }
            } catch (NumberFormatException n) {
                System.out.println("Người dùng nhập không phải số vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Error");
            }

        }
        float enterPrice;
        while (true) {
            try {
                System.out.println("Nhập chi phí cho thuê cho dịch vụ");
                enterPrice = Float.parseFloat(scanner.nextLine());
                if (enterPrice > 0) {
                    break;
                } else {
                    System.out.println("Chi phí phải là 1 số thực lớn hơn 0");
                }
            } catch (NumberFormatException n) {
                System.out.println("Người dùng nhập không phải số vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        int enterCapacity;
        while (true) {
            try {
                System.out.println("Nhập số lượng người tối đa được ở");
                enterCapacity = Integer.parseInt(scanner.nextLine());
                if ((enterCapacity > 0) && (enterCapacity < 20)) {
                    break;
                } else {
                    System.out.println("Nhập định dạng vui lòng nhập lại");
                }
            } catch (NumberFormatException n) {
                System.out.println("Người dùng nhập không phải là số");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        String enterTypeRental;
        TYE:
        while (true) {
            try {
                System.out.println("Chọn kiểu thuê");
                System.out.println("1.Thuê theo ngày");
                System.out.println("2.Thuê theo tháng");
                System.out.println("3.Thuê theo năm");
                System.out.println("4.Thuê theo giờ");
                int chose = Integer.parseInt(scanner.nextLine());
                switch (chose) {
                    case 1:
                        enterTypeRental = "Thuê theo ngày";
                        break TYE;
                    case 2:
                        enterTypeRental = "Thuê theo tháng";
                        break TYE;
                    case 3:
                        enterTypeRental = "Thuê theo năm";
                        break TYE;
                    case 4:
                        enterTypeRental = "Thuê theo giờ";
                        break TYE;
                    default:
                        System.out.println("Nhập sai vui lòng nhập lại");
                }
            } catch (NumberFormatException n) {
                System.out.println("Người dùng nhập không phải số vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        String enterFreeService;
        FEESE:
        while (true) {
            try {
                System.out.println("Chọn loại dịch vụ được miễn phí");
                System.out.println("1.Massage");
                System.out.println("2.Buffet sáng");
                System.out.println("3.Buffet tối");
                System.out.println("4. Coffee sáng");
                int chose = Integer.parseInt(scanner.nextLine());
                switch (chose) {
                    case 1:
                        enterFreeService = "Massage";
                        break FEESE;
                    case 2:
                        enterFreeService = "Buffet sáng";
                        break FEESE;
                    case 3:
                        enterFreeService = "Buffet tối";
                        break FEESE;
                    case 4:
                        enterFreeService = "Coffee sáng";
                        break FEESE;
                    default:
                        System.out.println("Nhập sai chức năng vui lòng nhập lại");
                }
            } catch (NumberFormatException n) {
                System.out.println("Người dùng nhập khoong phải số");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        Facility newRoom = new Room(enterCode, enterName, enterArea, enterPrice, enterCapacity, enterTypeRental, enterFreeService);
        facilityRepository.addRoom(newRoom);

    }


    public static void deleteFacility() {
        while (true) {
            System.out.println("Nhập mã dịch vụ Room cần xóa");
            String code = scanner.nextLine();
            boolean check = Validate.checkStringIn(code, "^SVRO\\d{4}$");
            Facility roomDele = null;
            if (check) {
                roomDele = facilityRepository.getByCode(code);
            } else {
                System.out.println("Nhập sai định dạng vui lòng nhập lại");
            }
            if (roomDele == null) {
                System.out.println("Mã dịch vụ không tồn tại");
                return;
            } else {
                while (true) {
                    try {
                        System.out.println("Bạn có chắc chắn là muốn xóa dịch vụ này không");
                        System.out.println("1.Xóa");
                        System.out.println("2.Suy nghĩ lại");
                        int chose = Integer.parseInt(scanner.nextLine());
                        switch (chose) {
                            case 1:
                                facilityRepository.removeRoom(roomDele);
                                return;
                            case 2:
                                return;
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
        }
    }

}
