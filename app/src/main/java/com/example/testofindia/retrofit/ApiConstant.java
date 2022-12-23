package com.example.testofindia.retrofit;


public class ApiConstant {

    public static final String BASE_URL = ""/*"http://ebgstore.net/"*/;
    public static final String CATEGORY_API = "/api/s1/MasterCategories";
    public static final String SUBCATEGORY_API = "/api/s1/Recipe/{id}";
    public static final String CHANNEL_API = "/api/s1/UserChannelDetail";
    public static final String CHANNEL_LIST_API = "/api/s1/ChannelNameImg";

    public static final String FILE_URL = "v1/";
    public static final String AUTHENTICATIONCODE = "authenticationcode=e3bf116csdcart7biik6bf952c3e92aad3";
    public static final String EXT_TABLE = "/ext_api_table/";

    public static final String URL = "https://qa-api-szgcm.tahaluf.ae/api/public/setup/";

    public static final String API_NATIONALITY = "public/setup/countries?api-version=1";
    public static final String API_GENDER ="public/setup/lookups?api-version=1&Type=Gender";
    public static final String API_AGE_GROUP = "public/setup/lookups?api-version=1&Type=AgeGroupType";
    public static final String API_INDIVIDUALCATEGORY =  "public/setup/lookups?api-version=1&Type=indivdualCategory";
    public static final String API_EMIRATE =  "public/setup/lookups?api-version=1&Type=emirate";
    public static final String API_CHECKPOINTLIST =  "public/setup/lookups?api-version=1&Type=LandmarkRegion";
    public static final String API_TIMESLOT = "/time-slots/available?api-version=1&LandmarkCode=31&TimeSlotTypeCode=48&VisitDate=2022-07-23&NumberOfUsers=1";
    public static final String POST_API_BOOKING = "public/bookings/individual?api-version=1";
    public static final String POST_API_TICKETSCAN = "public/tickets/scan?api-version=1";

    public static final String POST_REGISTER_DATA = FILE_URL + "user/register";
    public static final String UPDATE_PROFILE_DATA = FILE_URL + "user";
    public static final String UPDATE_PROFILE_ACTIVE = FILE_URL + "user/activate";
    public static final String USER_ACTIVITY_COUNTS = FILE_URL + "user/activity_counts";
    public static final String USER_NOTIFICATIONS_COUNTS = FILE_URL + "user/notification_counts";
    public static final String DELETE_LOGOUT = FILE_URL + "user/logout";

    public static final String GET_USER_DATA = FILE_URL + "user";
    public static final String GET_SEARCH_DATA = FILE_URL + "search";
    public static final String GET_SHIPPING_OPTION_DATA = FILE_URL + "shipping_options";

    public static final String GET_WATCH_DATA = FILE_URL + "watch";
    public static final String POST_WATCH_DATA = FILE_URL + "watch/{listing_id}";
    public static final String DELETE_WATCH_DATA = FILE_URL + "watch/{listing_id}";

    public static final String POST_STRIKE_INTIAL_OFFER = FILE_URL + "transaction/strike_a_deal/initial_offer";
    public static final String POST_STRIKE_COUNTER_OFFER = FILE_URL + "transaction/strike_a_deal/counter_offer";
    public static final String POST_STRIKE_DECLINE_OFFER = FILE_URL + "transaction/strike_a_deal/decline_offer";
    public static final String POST_STRIKE_ACCEPT_OFFER = FILE_URL + "transaction/strike_a_deal/accept_offer";
    public static final String POST_STRIKE_ACCEPT_COUNTER = FILE_URL + "transaction/strike_a_deal/accept_counter";
    public static final String POST_STRIKE_DECLINE_COUNTER = FILE_URL + "transaction/strike_a_deal/decline_counter";
    public static final String GET_STRIKE_DEALS_DATA = FILE_URL + "transaction/strike_a_deals";
    public static final String GET_STRIKE_DEALS_DETAILS = FILE_URL + "transaction/strike_a_deal_detail";

    public static final String POST_PURCHASES_DATA = FILE_URL + "transaction";
    public static final String GET_PURCHASES_DATA = FILE_URL + "transaction/purchases";
    public static final String POST_PAYMNET_CONFIRM_DATA = FILE_URL + "transaction/payment_confirm";

    public static final String GET_INBOX_MESSAGING_DATA = FILE_URL + "messaging/inbox";
    public static final String GET_OUTBOX_MESSAGING_DATA = FILE_URL + "messaging/outbox";
    public static final String GET_MESSAGING_DETAILS_DATA = FILE_URL + "messaging/message";
    public static final String PATCH_MESSAGING_DETAILS_DATA = FILE_URL + "messaging/mark_as_read";

    public static final String GET_BUSINESS_DATA = FILE_URL + "user/business_profile";
    public static final String GET_MEMBERSHIP_DATA = FILE_URL + "user/membership";
    public static final String GET_FOLLOW_DATA = FILE_URL + "user/follow";
    public static final String POST_FOLLOW_DATA = FILE_URL + "user/follow/{user_id}";
    public static final String DELETE_FOLLOW_DATA = FILE_URL + "user/follow/{user_id}";

    public static final String GET_CATEGORY_SUGGESTION_DATA = FILE_URL + "category_suggestions/";
    public static final String GET_PRODUCT_DETAILS_DATA = FILE_URL + "listing/{listingId}";
    public static final String GET_PRODUCT_DETAILS_DATA_VOLLEY = FILE_URL + "listing/";
    public static final String GET_USER_PRODUCT_DETAILS_DATA_VOLLEY = FILE_URL + "user_listing/";
    public static final String POST_PRODUCT = FILE_URL + "listings";
    public static final String PATCH_PRODUCT = FILE_URL + "listings/{listing_id}";
    public static final String PATCH_PRODUCT_END = FILE_URL + "listings/{listing_id}/end";
    public static final String PATCH_PRODUCT_RELIST = FILE_URL + "listings/{listing_id}/relist";

    public static final String GET_AUTOMOTIVE_DATA = FILE_URL + "automotive_lookup";

    public static final String SHOP_DATA = FILE_URL + "shop";
    public static final String POST_IMAGE = FILE_URL + "image";
    public static final String GET_PAYPAL_REGISTER = FILE_URL + "paypal/get_register_button";
    public static final String GET_TRUSTEPAY_REGISTER = FILE_URL + "trustepay/get_register_button";

    public static final String PATCH_CART_DATA = FILE_URL + "cart";
    public static final String GET_CART_OPTION_DATA = FILE_URL + "cart_options/{seller_id}";
    public static final String GET_CATEGORIES = FILE_URL + "categories";

}