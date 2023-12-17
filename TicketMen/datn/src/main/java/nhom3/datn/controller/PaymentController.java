package nhom3.datn.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import nhom3.datn.config.Config;

@RestController
public class PaymentController {
    // @PathParam("price") Long price, @PathParam("id") Integer billId
    @RequestMapping("/pay/{price}")
    public ModelAndView getPay(@PathVariable("price") Long price) throws UnsupportedEncodingException {

        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String orderType = "other";
        // long amount = 10000 * 100;
        price *= 100;
        String bankCode = "NCB";

        String vnp_TxnRef = Config.getRandomNumber(8);
        String vnp_IpAddr = "127.0.0.1";

        String vnp_TmnCode = Config.vnp_TmnCode;

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        // vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_Amount", String.valueOf(price));

        vnp_Params.put("vnp_CurrCode", "VND");

        vnp_Params.put("vnp_BankCode", bankCode);
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", vnp_TxnRef);
        vnp_Params.put("vnp_OrderType", orderType);

        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
        // vnp_Params.put("vnp_ReturnUrl", "http://localhost:8080/vnpay_callback");
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                // Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                // Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String vnpay = Config.vnp_PayUrl + "?" + queryUrl;

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(vnpay);

        // Trả về đối tượng ModelAndView với chuyển hướng đã được cấu hình
        return new ModelAndView(redirectView);
    }

    @RequestMapping("/vnpay_callback")
    public ModelAndView vnpayCallback(HttpServletRequest request) {
        String vnp_ResponseCode = request.getParameter("vnp_ResponseCode");
        String vnp_TxnRef = request.getParameter("vnp_TxnRef");
        String vnp_Amount = request.getParameter("vnp_Amount");
        String vnp_OrderInfo = request.getParameter("vnp_OrderInfo");
        String vnp_TransactionStatus = request.getParameter("vnp_TransactionStatus");

        // Xử lý dữ liệu callback ở đây

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vnp_ResponseCode", vnp_ResponseCode);
        modelAndView.addObject("vnp_TxnRef", vnp_TxnRef);
        modelAndView.addObject("vnp_Amount", vnp_Amount);
        modelAndView.addObject("vnp_OrderInfo", vnp_OrderInfo);
        modelAndView.addObject("vnp_TransactionStatus", vnp_TransactionStatus);

        if ("00".equals(vnp_ResponseCode) && "00".equals(vnp_TransactionStatus)) {
            modelAndView.setViewName("/payment/paymentSuccessPage"); 
        } else {
            modelAndView.setViewName("/payment/paymentFailurePage"); 
        }

        return modelAndView;
    }
}
