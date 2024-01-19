package TestScript;

import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

public class DriverScript {
    public static void main(String[] args) throws InterruptedException {

        CommanAction ca = new CommanAction();
        ca.launchApp();
        Xls_Reader xr = new Xls_Reader("C:\\Users\\gauri\\IdeaProjects\\basic_framework27aug\\src\\Tests.xlsx");

        int rowCount = xr.getRowCount("Sheet1");
        //System.out.println(rowCount);
        for (int i = 2; i <= rowCount; i++) {
            String run = xr.getCellData("Sheet1", "Run", i).trim();
            if (run.equalsIgnoreCase("ON")) {
                String tcname = xr.getCellData("Sheet1", "TestCases", i).trim();
                // System.out.println(tcname);
                switch (tcname) {
                    case "vTigerCrm_Verify_Title_01":
                        if (ca.verifyTitle("vtiger CRM - Commercial Open Source CRM").equals("passed")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;

                    case "vTigerCrm_Verify_Logo_02":
                        if (ca.elementDisplay("//img[@src='include/images/vtiger-crm.gif']")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }

                    case "vTigerCrm_Verify_vtigerCustomerPortal_Link_04":
                        if (ca.elementGetText("//a[text()='vtiger Customer Portal']").equals("vtiger Customer Portal")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }


                        break;

                    case "vTigerCrm_Verify_KeyModules_03":
                        if (ca.elementDisplay("//font[text()='Key Modules']")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;


                    case "vTigerCrm_Verify_UsernameFiled_Editable_05":
                        if (ca.GetTextBoxText("//input[@name='user_name']", "hello").equals("hello")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;


                    case "vTigerCrm_Verify_passwordField_Encrypted_06":
                        if (ca.GettypeAttribute("//input[@name='user_password']").equals("password")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;

                    case "vTigerCrm_Verify_LoginWithInvalidCedentials_07":

                        ca.login("gauri", "gauri123");
                        if (ca.elementDisplay("//td[contains(text(),'You must specify a valid username and password. ' )]")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;

                    case "vTigerCrm_Verify_LoginWithValidCedentials_08":

                        ca.login("admin", "admin");
                        if (ca.elementDisplay("//a[text()='Logout']")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;
                    case "vTigerCrm_MouseMoveActivities_09":

                        ca.MouseHover("//a[@id='showSubMenu']");
                        Thread.sleep(3000);
                        ca.MouseClick("//a[text()='New Vendor']");
                        if (ca.elementDisplay("//th[text()='Vendor Information:']")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;

                    case "vTigerCrm_Mouse_DragnDrop_Activities_10":

                        ca.ElementClick("//a[text()='My Account']");

                        ca.ElementClick("//input[@name='Customise']");
                        ca.DragAndDrop("//td[@id='cl4']", "//td[@id='cl8']");
                        if (ca.elementGetText("//td[@id='cl8']").equals("Leads")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;


                    case "vTigerCrm_Window_handles_11":

                        ca.ElementClick("//a[text()='New Contact']");

                        ca.ElementClick("//input[@name='btn1']");
                        Thread.sleep(6000);
                        ca.WindowHandle();
                        if (ca.GetTextBoxText("//input[@name='account_name']").equals("vtiger")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;

                    case "vTigerCrm_Tab_handles_12":

                        ca.ElementClick("//a[text()='Logout']");
                        ca.ElementClick("//a[text()='vtiger Customer Portal']");
                        ca.TabHandles();
                        if (ca.elementDisplay("//a[text()='Logout']")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;
                    case "vTigerCrm verify that new lead is created or not":
                        ca.newLeadCheck();
                        if (ca.elementDisplay("//td[text()='Lead:   swapnil']")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;
                    case "vTigerCrm_Alert_handles_13":

                        if (ca.alertHandles1()) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;
                    case "vtiger crm file uploading":
                        ca.fileUpload();
                        if (ca.elementDisplay("//a[text()='Manual_Testing.pptx']")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;
                    case "vtiger crm choosefile alert msg generate or not":

                        if (ca.fileuploadjpgmsgalert()) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;
                    case "vtiger crm product window handle":
                        ca.productWindohandle();

                        if (ca.GetTextBoxText("//input[@name='contact_name']").equals("Mary Smith")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }
                        break;
                    case "vtigercrm verify that value is selected or not in dropdown":

                        ca.DropdownHandling();
                        Thread.sleep(8000);

                        if (ca.elementDisplay("//input[@name='Merge']")) {
                            System.out.println(tcname + "=passed");
                            xr.setCellData("Sheet1", "Status", i, "passed");

                        } else {
                            System.out.println(tcname + "=failed");
                            xr.setCellData("Sheet1", "Status", i, "Failed");
                        }

                        break;


                    /*case"verify size of links":

                    ca.checklink_size();
                    ca.check_font_size();
                        System.out.println("pass");
                }}
*/


                }

            }
        }
    }
}