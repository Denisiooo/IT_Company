package DAO;

import Hierarchy.Contract;
import Hierarchy.Financing;
import Hierarchy.ParticipationInDevelopment;
import Hierarchy.Programmers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static AllOptions currentState = AllOptions.ALL;
    private static AllDAOClasses selectedOption = null;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a;
        boolean exit = false;

        while (!exit) {
            switch (currentState) {
                case ALL -> {
                    LOGGER.info("\n1 - INSERT\n2 - UPDATE\n3 - DELETE\n4 - PRINT\n0 - EXIT");
                    boolean validInt = false;
                    a = 0;
                    a = scanner.nextInt();
                    if (a < 0 || a > 4) {
                        LOGGER.info("YOU ENTER WRONG NUMBER. TRY IT AGAIN");
                        currentState = AllOptions.ALL;
                    }

                    switch (a) {
                        case 1 -> currentState = AllOptions.INSERT;
                        case 2 -> currentState = AllOptions.UPDATE;
                        case 3 -> currentState = AllOptions.DELETE;
                        case 4 -> currentState = AllOptions.PRINT;
                        case 0 -> currentState = AllOptions.EXIT;
                        default -> currentState = AllOptions.ALL;
                    }
                }
                case INSERT -> {
                    IBaseDAO iBaseDAO = getClass(scanner);
                    switch (selectedOption) {
                        case PROGRAMMERS -> {
                            Programmers programmers = new Programmers();
                            LOGGER.info("Enter surname");
                            programmers.setSurname(scanner.next());
                            LOGGER.info("Enter name");
                            programmers.setName(scanner.next());
                            LOGGER.info("Enter patronymic");
                            programmers.setPatronymic(scanner.next());
                            LOGGER.info("Enter phone number");
                            programmers.setPhoneNumber(scanner.nextInt());
                            LOGGER.info("Enter date of birth");
                            programmers.setDateOfBirth(scanner.next());
                            iBaseDAO.create(programmers);
                            currentState = AllOptions.ALL;
                        }
                        case PARTICIPATION_IN_DEVELOPMENT -> {
                            ParticipationInDevelopment participationInDevelopment = new ParticipationInDevelopment();
                            LOGGER.info("Enter calendar plan Id");
                            participationInDevelopment.setCalendarPlanId(scanner.nextInt());
                            LOGGER.info("Enter employee Id");
                            participationInDevelopment.setEmployeeId(scanner.nextInt());
                            LOGGER.info("Enter employee");
                            participationInDevelopment.setEmployee(scanner.next());
                            LOGGER.info("Enter job description");
                            participationInDevelopment.setJobDescription(scanner.next());
                            LOGGER.info("Enter programming language");
                            participationInDevelopment.setProgrammingLanguage(scanner.next());
                            iBaseDAO.create(participationInDevelopment);
                            currentState = AllOptions.ALL;
                        }
                        case FINANCING -> {
                            Financing financing = new Financing();
                            LOGGER.info("Enter software Id");
                            financing.setSoftwareId(scanner.nextLong());
                            LOGGER.info("Enter investor Id");
                            financing.setInvestorId(scanner.nextInt());
                            LOGGER.info("Enter investor");
                            financing.setInvestor(scanner.next());
                            LOGGER.info("Enter amount");
                            financing.setAmount(scanner.nextInt());
                            iBaseDAO.create(financing);
                            currentState = AllOptions.ALL;
                        }
                        case CONTRACT -> {
                            Contract contract = new Contract();
                            LOGGER.info("Enter customer Id");
                            contract.setCustomerId(scanner.nextLong());
                            LOGGER.info("Enter customer");
                            contract.setCustomer(scanner.next());
                            LOGGER.info("Enter description");
                            contract.setDescription(scanner.next());
                            LOGGER.info("Enter agreement date");
                            contract.setAgreementDate(scanner.next());
                            LOGGER.info("Enter deadline");
                            contract.setDeadline(scanner.next());
                            LOGGER.info("Enter development cost");
                            contract.setDevelopmentCost(scanner.nextInt());
                            iBaseDAO.create(contract);
                            currentState = AllOptions.ALL;
                        }
                        default -> currentState = AllOptions.INSERT;
                    }
                }
                case UPDATE -> {
                    IBaseDAO iBaseDAO = getClass(scanner);
                    switch (selectedOption) {
                        case PROGRAMMERS -> {
                            Programmers programmers = new Programmers();
                            LOGGER.info("Enter new phone number");
                            programmers.setPhoneNumber(scanner.nextInt());
                            LOGGER.info("Enter employee Id");
                            programmers.setIdEmployee(scanner.nextLong());
                            iBaseDAO.update(programmers);
                            currentState = AllOptions.ALL;
                        }
                        case PARTICIPATION_IN_DEVELOPMENT -> {
                            ParticipationInDevelopment participationInDevelopment = new ParticipationInDevelopment();
                            LOGGER.info("Enter new programming language");
                            participationInDevelopment.setProgrammingLanguage(scanner.next());
                            LOGGER.info("Enter Id");
                            participationInDevelopment.setId(scanner.nextLong());
                            iBaseDAO.update(participationInDevelopment);
                            currentState = AllOptions.ALL;
                        }
                        case FINANCING -> {
                            Financing financing = new Financing();
                            LOGGER.info("Enter new investor");
                            financing.setInvestor(scanner.next());
                            LOGGER.info("Enter Id");
                            financing.setId(scanner.nextLong());
                            iBaseDAO.update(financing);
                            currentState = AllOptions.ALL;
                        }
                        case CONTRACT -> {
                            Contract contract = new Contract();
                            LOGGER.info("Enter new customer");
                            contract.setCustomer(scanner.next());
                            LOGGER.info("Enter Id");
                            contract.setIDNumberOfContract(scanner.nextLong());
                            iBaseDAO.update(contract);
                            currentState = AllOptions.ALL;
                        }
                        default -> currentState = AllOptions.UPDATE;
                    }
                }
                case DELETE -> {
                    IBaseDAO iBaseDAO = getClass(scanner);
                    switch (selectedOption) {
                        case PROGRAMMERS, PARTICIPATION_IN_DEVELOPMENT, FINANCING, CONTRACT -> {
                            LOGGER.info("Enter Id");
                            iBaseDAO.remove(scanner.nextLong());
                            currentState = AllOptions.ALL;
                        }
                    }
                }
                case PRINT -> {
                    IBaseDAO iBaseDAO = getClass(scanner);
                    LOGGER.info("\n1 - PRINT ALL FIELDS\n2 - PRINT FIELDS BY CHOSEN ID\n3 - STEP BACK");
                    a = 0;
                    a = scanner.nextInt();
                    if (a < 1 || a > 3) {
                        LOGGER.info("YOU ENTER WRONG NUMBER. TRY IT AGAIN");
                        currentState = AllOptions.PRINT;
                    }
                    if (a==3) {
                        currentState = AllOptions.PRINT;
                    }
                    switch (selectedOption) {
                        case PROGRAMMERS, PARTICIPATION_IN_DEVELOPMENT, FINANCING, CONTRACT -> {
                            switch (a) {
                                case 1 -> {
                                    iBaseDAO.findAll();
                                    currentState = AllOptions.ALL;
                                }
                                case 2 -> {
                                    LOGGER.info("Enter Id");
                                    iBaseDAO.getEntityById(scanner.nextLong());
                                    currentState = AllOptions.ALL;
                                }
                                default -> currentState = AllOptions.PRINT;
                            }
                        }
                    }
                }
                case EXIT -> {
                    LOGGER.info("\nDO YOU WANT TO EXIT?\nIF YES ENTER 'Y'; IF NO ENTER 'N':");
                    char ch = Character.toLowerCase(scanner.next().trim().charAt(0));
                    switch (ch) {
                        case 'y' -> {
                            LOGGER.info("THANKS, GOOD DAY AND GOODBYE");
                            exit = true;
                        }
                        case 'n' -> {
                            currentState = AllOptions.ALL;
                        }
                    }
                }
                default -> throw new RuntimeException("YOU ENTERED THE WRONG NUMBER");
            }
        }
        scanner.close();
    }

    private static IBaseDAO getClass(Scanner scanner) {
        LOGGER.info("\n1 - PROGRAMMERS\n2 - PARTICIPATION_IN_DEVELOPMENT\n3 - FINANCING\n4 - CONTRACT");
        IBaseDAO iBaseDAO = null;
        int a = 0;
        a = scanner.nextInt();
        if (a < 0 || a > 4) {
            LOGGER.info("YOU ENTER WRONG NUMBER. TRY IT AGAIN");
            currentState = AllOptions.ALL;
        }

        switch (a) {
            case 1 -> {
                iBaseDAO = new ProgrammersDAO();
                selectedOption = AllDAOClasses.PROGRAMMERS;
            }
            case 2 -> {
                iBaseDAO = new ParticipationInDevelopmentDAO();
                selectedOption = AllDAOClasses.PARTICIPATION_IN_DEVELOPMENT;
            }
            case 3 -> {
                iBaseDAO = new FinancingDAO();
                selectedOption = AllDAOClasses.FINANCING;
            }
            case 4 -> {
                iBaseDAO = new ContractDAO();
                selectedOption = AllDAOClasses.CONTRACT;
            }
            default -> {
                currentState = AllOptions.ALL;
            }
        }
        return iBaseDAO;
    }
}


//        int a = scanner.nextInt();
//        switch (a) {
//            case 1:
//                LOGGER.info("work");
//                ProgrammersDAO programmersDAO = new ProgrammersDAO();
//                Programmers programmers = new Programmers();
////                programmers.setIdEmployee(scanner.nextLong());
//                programmers.setSurname(scanner.next());
//                programmers.setName(scanner.next());
//                programmers.setPatronymic(scanner.next());
//                programmers.setPhoneNumber(scanner.nextInt());
//                String str = scanner.next();
//                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
//                java.util.Date date = s.parse(str);
//                programmers.setDateOfBirth((Date) date);
//                programmersDAO.create(programmers);
//                break;
//            case 2:
//                System.out.println("work2");
//                ProgrammersDAO programmersDAO1 = new ProgrammersDAO();
//                programmersDAO1.findAll();
//                programmersDAO1.remove(scanner.nextLong());
//                break;
//            case 3:
//                System.out.println("work 3");
//                ProgrammersDAO programmersDAO2 = new ProgrammersDAO();
//                Programmers programmers1 = new Programmers();
//                programmers1.setPhoneNumber(scanner.nextInt());
//                programmers1.setIdEmployee(scanner.nextLong());
//                programmersDAO2.update(programmers1);
//                break;
//            case 4:
//                System.out.println("work4");
//                ProgrammersDAO programmersDAO3 = new ProgrammersDAO();
//                programmersDAO3.getEntityById(scanner.nextLong());
//        }
//    }
//}
