package uz.pdp.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springsecurity.aotations.CheckPermission;
import uz.pdp.springsecurity.payload.ApiResponse;
import uz.pdp.springsecurity.payload.PurchaseDto;
import uz.pdp.springsecurity.service.PurchaseService;

import java.sql.Date;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    //    @CheckPermission("ADD_PURCHASE")
    @PostMapping
    public HttpEntity<?> add(@RequestBody PurchaseDto purchaseDto) {
        ApiResponse apiResponse = purchaseService.add(purchaseDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    //    @CheckPermission("EDIT_PURCHASE")
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody PurchaseDto purchaseDto) {
        ApiResponse apiResponse = purchaseService.edit(id, purchaseDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    //    @CheckPermission("VIEW_PURCHASE")
    @GetMapping("/{id}")
    public HttpEntity<?> get(@PathVariable Integer id) {
        ApiResponse apiResponse = purchaseService.get(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

//    @CheckPermission("VIEW_PURCHASE")
    @GetMapping
    public HttpEntity<?> getAll() {
        ApiResponse apiResponse = purchaseService.getAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    //    @CheckPermission("DELETE_PURCHASE")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = purchaseService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    //    @CheckPermission("DELETE_PURCHASE")
    @DeleteMapping
    public HttpEntity<?> deleteAll() {
        ApiResponse apiResponse = purchaseService.deleteAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    //    @CheckPermission("VIEW_PURCHASE")
    @GetMapping("get-purchase-by-dealerId/{dealer_id}")
    public HttpEntity<?> getByDealerId(Integer dealer_id) {
        ApiResponse apiResponse = purchaseService.getByDealerId(dealer_id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    //    @CheckPermission("VIEW_PURCHASE")
    @GetMapping("get-purchase-by-purchaseStatus/{purchaseStatus_id}")
    public HttpEntity<?> getByPurchaseStatusId(Integer purchaseStatus_id) {
        ApiResponse apiResponse = purchaseService.getByPurchaseStatusId(purchaseStatus_id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    //    @CheckPermission("VIEW_PURCHASE")
    @GetMapping("get-purchase-by-paymentStatus/{paymentStatus_id}")
    public HttpEntity<?> getByPaymentStatusId(Integer paymentStatus_id) {
        ApiResponse apiResponse = purchaseService.getByPaymentStatusId(paymentStatus_id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    //    @CheckPermission("VIEW_PURCHASE")
    @GetMapping("get-purchase-by-branch/{branch_id}")
    public HttpEntity<?> getByBranchId(Integer branch_id) {
        ApiResponse apiResponse = purchaseService.getByBranchId(branch_id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    //    @CheckPermission("VIEW_PURCHASE")
    @GetMapping("get-purchase-by-date/{date}")
    public HttpEntity<?> getByDate(Date date) {
        ApiResponse apiResponse = purchaseService.getByDate(date);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    //    @CheckPermission("VIEW_PURCHASE")
    @GetMapping("get-purchase-by-totalSum/{totalSum}")
    public HttpEntity<?> getByTotalSum(double totalSum) {
        ApiResponse apiResponse = purchaseService.getByTotalSum(totalSum);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}