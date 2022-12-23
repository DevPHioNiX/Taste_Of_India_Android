package com.example.testofindia.utils;

import retrofit2.http.Query;

public class CustomeConstants {

    public static final String APP_PREFERENCE_NAME = "CSDCartAppSharedPreference";
    public static final String LANG_SELECTION = "lang_selection";
    public static final String LANG_AR = "ar";
    public static final String LANG_EN = "en";
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String IS_LOGIN = "is_login";
    public static final String C_TYPE = "ID";
    public static final String CASE_ID = "CASE_ID";
    public static final String VERIFICATION_TYPE_ID = "VERIFICATION_TYPE_ID";
    public static final String CLIENT_NAME = "CLIENT_NAME";
    public static final String ALLOCATION_DATE = "ALLOCATION_DATE";
    public static final String CASE_NO = "CASE_NO";
    public static final String FOS_ID = "FOD_ID";
    public static final String VISITY_STATUS = "VISITY_STATUSID";
    public static final String CASE_TYPE = "CASE_TYPE";
    public static final String CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String CUSTOMER_NO = "CUSTOMER_NO";
    public static final String CUSTOMER_ADDRESS = "CUSTOMER_ADDRESS";
    public static final String REMARK = "REMARK";

    public static final String WIFI = "wifi";
    public static final String MOBILE_DATA = "mobile";
    public static final String NO_INTERNET = "no_internet";

    public static final String API_KEY = "yumitos.api.123";

    public static final String LOGGER_CUSTOM_TAG = "CSD_Cart-Android-App-Logging";

    /**
     * Input form - length validation
     **/
    public static final Integer PASSWORD_MIN_LENGTH = 7;
    public static final Integer PASSWORD_MAX_LENGTH = 16;
    public static final Integer NAME_MIN_LENGTH = 2;
    public static final Integer NAME_MAX_LENGTH = 50;

    public static final int HOME_PAGE_RESULT_CODE = 200;
    public static final int HOTEL_LISTING_CODE = 201;
    public static final int CATEGORY_RESULT_CODE = 203;
    public static final int NOTIFICATION_RESULT_CODE = 206;
    public static final int ORDER_RESULT_CODE = 207;
    public static final int ORDER_SUMMARY_RESULT_CODE = 208;

    public static final int BOOKING_RESULT_CODE = 302;

    public static final String MAX_DATE = "maximum_date";
    public static final String MIN_DATE = "minimum_date";
    public static final String STATUS = "status";

    public static final String ADMIN_DATA = "adminData";
    public static final String USER_DATA = "userData";
    public static final String USER_ACTIVITY_COUNT_DATA = "userActivityCountData";
    public static final String USER_NOTIFICATION_COUNT_DATA = "userNotificationCountData";
    public static final String CATEGORY_DATA = "categoriesData";
    public static final String DAILY_MILK_DATA = "dailyMilkData";
    public static final String USER_CART_DATA = "userCartData";
    public static final String USER_FOLLOW_DATA = "userFollowData";
    public static final String USER_WATCH_DATA = "userWatchData";
    public static final String SETTINGS_DATA = "settingsData";
    public static final String USER_CART_DATA_COUNT = "userCartDataCount";
    public static final String USER_NOTIFICATION_COUNT = "userNotificationCount";

    public static final String DEVICE_TYPE_ANDROID = "Android";
    public static final String DEVICE_ID = "device_id";
    public static final String DEVICE_TYPE = "device_type";
    public static final String DEVICE_NAME = "device_name";
    public static final String ANDROID_VERSION = "android_version";
    public static final String APPLICATION_VERSION = "application_version";
    public static final String FIREBASE_ID = "firebase_id";
    public static final String SERVER_KEY = "server_key";
    public static final String PAYMENT_GATEWAY_JSON = "payment_gateway_json";
    public static final String VERIFIED = "VERIFIED";

    public static final String START_TIMESTAMP = "start_timestamp";
    public static final String END_TIMESTAMP = "end_timestamp";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String CHECK_IN_DATE = "check_in_date";
    public static final String CHECK_OUT_DATE = "check_out_date";
    public static final String NO_OF_ROOM = "no_of_room";
    public static final String NO_OF_ADULTS = "no_of_adults";
    public static final String NO_OF_CHILD = "no_of_child";
    public static final String TRENDING_HOTELS = "trending_hotels";
    public static final String TOP_DESTINATION = "top_destination";
    public static final String BEST_HOTELS = "best_hotels";
    public static final String HOTELS_LIST = "hotels";
    public static final String ON = "on";
    public static final String OFF = "off";

    public static final String NATIONALITY_DATA = "nationality_data";
    public static final String GENDER_DATA = "gender_data";
    public static final String AGE_GROUP_DATA = "age_group_data";
    public static final String INDIVIDUAL_CATEGORY = "Individual_Category";
    public static final String EMIRATE = "Emi_Rate";
    public static final String CHECKPOINT = "chekpoint";

    /***
     SHARED PREFERENCES KEYS
     ***/
    public static final String USER_ID = "user_id";
    public static final String USER_TOKEN = "user_token";
    public static final String USER_NAME = "user_name";
    public static final String MEMBER_NAME = "Member_name";
    public static final String MEMBER_EMAIL = "Member_email";

    public static final String USER_PROFILE_PIC = "user_profile_pic";
    public static final String USER_TYPE = "user_type";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_PHONE_NUMBER = "user_phone_number";
    public static final String USER_AUTH_ID = "user_auth_id";
    public static final String USER_ADDRESS = "user_address";
    public static final String USER_CITY = "user_city";
    public static final String USER_ZIPCODE = "user_zipcode";
    public static final String USER_COUNTRYCODE = "user_countrycode";
    public static final String BEARER_TOKEN = "bearer_token";
    public static final String BEARER_KEY = "Bearer ";
    public static final String PROFILE = "Profile ";
    public static final String POSITION = "Position ";

    public static final String BOOKING_STATUS = "booking_status";
    public static final String PAYMENT_METHOD_CARD = "card";

    public static final String BOOKING_STATUS_PENDING = "Pending";
    public static final String BOOKING_STATUS_SUCCEEDED = "Succeeded";
    public static final String BOOKING_STATUS_FAILED = "Failed";
    public static final String BOOKING_STATUS_BOOKIG_DONE = "Booking Done";

    public static final String X_API_KEY = "x-api-key";
    //    public static final String X_API_KEY_VALUE = "07dcfee93561755dd6a76d30f4e23a35";
    public static final String X_API_KEY_VALUE = "2ede7df06de40789c4542b55fed208bd";
    public static final String FACEBOOK = "facebook";
    public static final String GOOGLE = "google";
    public static final String CONTENT_TYPE_JSON = "Content-Type";
    public static final String APPLICATION_TYPE_JSON = "application/json";

    public static final String PRIACY_POLISY_URL = "Privacy policies";
    public static final String TEARM_CONDITION_URL = "Terms Condition";
    public static final String RAZORPAY_KEY = "razorpay_Key";
    public static final String IS_COD_ORDER = "is_Cod_Order";
    public static final String ABOUT_US_URL = "About Us";
    public static final String CONTACT_US_URL = "Contact Us";
    public static final String FAQ_URL = "faq_url";
    public static final String MY_EARN_URL = "URL";

    public static final String PAYMONGO_AUTH = "Authorization";
    public static final String PAYMONGO_AUTH_KEY = "Basic c2tfdGVzdF9oQm1YdHdtZlFMeE53N1djRGhTeE1maW8=";

    public static final String RESIDENCE_CaseId ="CaseId";
    public static final String RESIDENCE_FOSId ="FOSId";
    public static final String RESIDENCE_VisitStatusId ="VisitStatusId";
    public static final String RESIDENCE_AddressExistLocalty ="AddressExistLocalty";
    public static final String RESIDENCE_AddressTraced ="AddressTraced";
    public static final String RESIDENCE_AnyVehicle ="AnyVehicle";
    public static final String RESIDENCE_ApplicantDOB ="ApplicantDOB";
    public static final String RESIDENCE_CoApplicantDOB ="CoApplicantDOB" ;
    public static final String RESIDENCE_AssetsseenElectronics ="AssetsseenElectronics";
    public static final String RESIDENCE_DocumentProof ="DocumentProof";
    public static final String RESIDENCE_DocumentProofDetails ="DocumentProofDetails";
    public static final String RESIDENCE_EarningMember ="EarningMember";
    public static final String RESIDENCE_HouseAreaApproxSqft ="HouseAreaApproxSqft";
    public static final String RESIDENCE_LoanPurpose ="LoanPurpose";
    public static final String RESIDENCE_Localityofhouse ="Localityofhouse";
    public static final String RESIDENCE_MaritalStatus ="MaritalStatus";
    public static final String RESIDENCE_MetPersoneName ="MetPersoneName";
    public static final String RESIDENCE_MetTPCNeighbour1 ="MetTPCNeighbour1";
    public static final String RESIDENCE_MetTPCNeighbour1Designation ="MetTPCNeighbour1Designation";
    public static final String RESIDENCE_MetTPCNeighbour2 ="MetTPCNeighbour2";
    public static final String RESIDENCE_MetTPCNeighbour2Designation ="MetTPCNeighbour2Designation";
    public static final String RESIDENCE_NamePlateSeen ="NamePlateSeen";
    public static final String RESIDENCE_NoofYearsatPresentAddress ="NoofYearsatPresentAddress";
    public static final String RESIDENCE_OwnershipofhouseParents ="OwnershipofhouseParents";
    public static final String RESIDENCE_QualificationofApplicant ="QualificationofApplicant";
    public static final String RESIDENCE_QualificationofCoapplicant ="QualificationofCoapplicant";
    public static final String RESIDENCE_RelationwithApplicant ="RelationwithApplicant";
    public static final String RESIDENCE_SpouseEarning ="SpouseEarning";
    public static final String RESIDENCE_TotalFamilyMember ="TotalFamilyMember";
    public static final String RESIDENCE_TypeofHouse ="TypeofHouse";
    public static final String RESIDENCE_VehicleNumber ="VehicleNumber";
    public static final String RESIDENCE_Observation ="Observation";
    public static final String RESIDENCE_CaseLatLog ="CaseLatLog";
    public static final String RESIDENCE_CaseLocation ="CaseLocation";
    public static final String RESIDENCE_SignPhotoName ="SignPhotoName";
    public static final String RESIDENCE_PhotosNameList ="PhotosNameList";
    public static final String RESIDENCE_CreatedBy ="CreatedBy";
    public static final String RESIDENCE_extrareq ="extrareq";


    public static final String BUSINESS_BusinessLocationTraced ="BusinessLocationTraced";
    public static final String BUSINESS_BusinessBoardSeen ="BusinessBoardSeen";
    public static final String BUSINESS_MetTPCNeighbour1 ="MetTPCNeighbour1";
    public static final String BUSINESS_MetTPCNeighbour1Address ="MetTPCNeighbour1Address";
    public static final String BUSINESS_MetTPCNeighbour2 ="MetTPCNeighbour2";
    public static final String BUSINESS_MetTPCNeighbour2Address ="MetTPCNeighbour2Address";
    public static final String BUSINESS_BusinessExistLocalty ="BusinessExistLocalty";
    public static final String BUSINESS_BusinessSector ="BusinessSector";
    public static final String BUSINESS_NatureofBusiness ="NatureofBusiness";
    public static final String BUSINESS_BusinessArea ="BusinessArea";
    public static final String BUSINESS_IDCardProvidedbyCompany ="IDCardProvidedbyCompany";
    public static final String BUSINESS_BusinessPremises ="BusinessPremises";
    public static final String BUSINESS_MetPersoneName ="MetPersoneName";
    public static final String BUSINESS_MetPersoneDesignation ="MetPersoneDesignation";
    public static final String BUSINESS_ApplicantAvailable ="ApplicantAvailable";
    public static final String BUSINESS_ApplicantName ="ApplicantName";
    public static final String BUSINESS_ApplicantDOB ="ApplicantDOB";
    public static final String BUSINESS_ApplicantQualification ="ApplicantQualification";
    public static final String BUSINESS_Applicantdesignation ="Applicantdesignation";
    public static final String BUSINESS_BusinessRunningSinceinthisoffice ="BusinessRunningSinceinthisoffice";
    public static final String BUSINESS_AppTotalBusinessExperience ="AppTotalBusinessExperience";
    public static final String BUSINESS_IncomceApproxperMonth ="IncomceApproxperMonth";
    public static final String BUSINESS_EmployeeSeenatoffice ="EmployeeSeenatoffice";
    public static final String BUSINESS_NoofEmployeeSeen ="NoofEmployeeSeen";
    public static final String BUSINESS_CompanySalaryprovides ="CompanySalaryprovides";
    public static final String BUSINESS_BusinessAvedenceSeen ="BusinessAvedenceSeen";
    public static final String BUSINESS_StockSeen ="StockSeen";
    public static final String BUSINESS_StockStoreatotherplace ="StockStoreatotherplace";
    public static final String BUSINESS_StockAddress ="StockAddress";
    public static final String BUSINESS_GSTNo ="GSTNo";
    public static final String BUSINESS_Landmark ="Landmark";
    public static final String BUSINESS_LocalRegdCertificate ="LocalRegdCertificate";
    public static final String BUSINESS_CurrentAccountBankName ="CurrentAccountBankName";
    public static final String BUSINESS_CurrentAccountBankDetails ="CurrentAccountBankDetails";
    public static final String BUSINESS_NumberofBusinessPartner ="NumberofBusinessPartner";
    public static final String BUSINESS_NameofothersBusinessPartner ="NameofothersBusinessPartner";


    public static final String OFFICE_OfficeTraced ="OfficeTraced";
    public static final String OFFICE_OfficeBoardSeen ="OfficeBoardSeen";
    public static final String OFFICE_MetTPCEmployee1 ="MetTPCEmployee1";
    public static final String OFFICE_MetTPCEmployee1Designation ="MetTPCEmployee1Designation";
    public static final String OFFICE_MetTPCEmployee2 ="MetTPCEmployee2";
    public static final String OFFICE_MetTPCEmployee2Designation ="MetTPCEmployee2Designation";
    public static final String OFFICE_CompanyExistLocalty ="CompanyExistLocalty";
    public static final String OFFICE_CompanySector ="CompanySector";
    public static final String OFFICE_NatureofBusiness ="NatureofBusiness";
    public static final String OFFICE_OfficeArea ="OfficeArea";
    public static final String OFFICE_IDCardProvidedbyCompany ="IDCardProvidedbyCompany";
    public static final String OFFICE_Premisesowned ="Premisesowned";
    public static final String OFFICE_ApplicantAvailable ="ApplicantAvailable";
    public static final String OFFICE_ApplicantName ="ApplicantName";
    public static final String OFFICE_ApplicantDOB ="ApplicantDOB";
    public static final String OFFICE_ApplicantQualification ="ApplicantQualification";
    public static final String OFFICE_ApplicantWorkingSinceinthisoffice ="ApplicantWorkingSinceinthisoffice";
    public static final String OFFICE_Applicantdesignation ="Applicantdesignation";
    public static final String OFFICE_ApplicantTotalworkExperience ="ApplicantTotalworkExperience";
    public static final String OFFICE_SalaryApproxperMonth ="SalaryApproxperMonth";
    public static final String OFFICE_ReportingManagerName ="ReportingManagerName";
    public static final String OFFICE_ReportingManagerDesignation ="ReportingManagerDesignation";
    public static final String OFFICE_ApplicantWorkRoal ="ApplicantWorkRoal";
    public static final String OFFICE_ApplicantLastWorkedCompanyName ="ApplicantLastWorkedCompanyName";
    public static final String OFFICE_ApplicantLastWorkedLocation ="ApplicantLastWorkedLocation";
    public static final String OFFICE_ApplicantLastWorkedDuration ="ApplicantLastWorkedDuration";
    public static final String OFFICE_Salaryprovidedby ="Salaryprovidedby";
    public static final String OFFICE_EmployeeSeenatoffice ="EmployeeSeenatoffice";
    public static final String OFFICE_NoofEmployeeSeen ="NoofEmployeeSeen";
    public static final String OFFICE_EmployeeAvedenceSeenatOffice ="EmployeeAvedenceSeenatOffice";
    public static final String OFFICE_Landmark ="Landmark";


//    public static final String statusRejected = "rejected"; //Cancel order - red
//    public static final String statusCancle = "cancle"; //Cancel order - red
//    public static final String statusPlaced = "placed"; //Not Deliver - blue
//    public static final String statusDelivered = "delivered"; //Delivered order - green
//    public static final String statusVacation = "vacation"; //Vacation Time - yellow
//    public static final String statusPacked = "packed"; //Packing Time tommrow delivery - orange
//    public static final String statusBlank = "blank"; //Blank day - grey
    //rejected

    public static final String DELETE_ADDRESS = "delete_Address";
    public static final String DELETE_WISHLIST = "delete_Wishlist";
    public static final String ADD_WISHLIST = "add_Wishlist";
    public static final String DELETE_CART = "delete_Cart";
    public static final String ADD_CART = "add_Cart";
    public static final String VIEWDETAILS = "View_Details";
    public static final String VARIANT_PRODUCT_CLICK = "Variant_Product_Click";
    public static final String PRODUCT_ID = "PRODUCT_ID";

    public static final String status_continue = "Continue";
    public static final String status_on_progress = "On Progress";
    public static final String status_completed = "Completed";
    public static final String status_after_sometimes = "After Sometimes";
    public static final String status_break_time = "Break Time";
    public static final String status_cancelled = "Cancelled";

    public static final String strike_a_deal_offers = "offers";
    public static final String strike_a_deal_offers_ = "Offers";
    public static final String strike_a_deal_to_pay = "awaiting-payment";
    public static final String strike_a_deal_to_pay_ = "To Pay";
    public static final String strike_a_deal_awaiting_payment_ = "Awaiting Payment";
    public static final String strike_a_deal_accepted = "accepted";
    public static final String strike_a_deal_accepted_ = "Accepted";
    public static final String strike_a_deal_declined = "declined";
    public static final String strike_a_deal_declined_ = "Declined";
    public static final String strike_a_deal_expired = "expired";
    public static final String strike_a_deal_expired_ = "Expired";

    public static final String purchases_awaiting_despatch = "awaiting_despatch";
    public static final String purchases_awaiting_despatch_ = "Awaiting Despatch";
    public static final String purchases_despatch = "despatched";
    public static final String purchases_despatch_ = "Despatched";
    public static final String purchases_awaiting_collection = "awaiting_collection";
    public static final String purchases_awaiting_collection_ = "Awaiting Collection";
    public static final String purchases_completed = "completed";
    public static final String purchases_completed_ = "Completed";

    public static final String classified_general = "0";//general
    public static final String classified_classified = "1";//classified

    public static final String active_listings_active = "1";//active
    public static final String active_listings_complete = "0";//completed

    public static final String status_online = "Online";
    public static final String status_offline = "Offline";
    //1-cheque=pMethodId
    //2-cash=pMethodId
    //3-UPI=pMethodId
    //4-DD=pMethodId

    //pStatus = "Failed"
    //pStatus = "Cancel"
    //pStatus = "Complete"
    //pStatus = "Pending"

//month-count-odd/even
//31 - 30 - 2
//28 - 27 - 1
//31 - 31 - 1
//30 - 30 - 2
//31 - 30 - 2
//30 - 29 - 1
//31 - 31 - 1
//31 - 30 - 2
//30 - 29 - 1
//31 - 31 - 1
//30 - 30 - 2
//31 - 30 - 2

    //"1#gold#2.0#placed" day#type#liter#status
    public static final int FOOD_ITEM_LIST_CALL_BACK_NUMBER = 104;
    public static final int ADD_FOOD_CALL_BACK_NUMBER = 105;
    public static final int CATEGORY_LIST_CALL_BACK_NUMBER = 102;

}
