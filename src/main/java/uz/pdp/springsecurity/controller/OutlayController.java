package uz.pdp.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springsecurity.annotations.CheckPermission;
import uz.pdp.springsecurity.payload.ApiResponse;
import uz.pdp.springsecurity.payload.OutlayDto;
import uz.pdp.springsecurity.service.OutlayService;

import javax.validation.Valid;
import java.sql.Date;

@RestController
@RequestMapping("/api/outlay")
public class OutlayController {

    @Autowired
    OutlayService outlayService;

    /**
     * YANGI CHIQIM QO'SHISH
     *
     * @param outlayDto
     * @return ApiResponse(success - > true message - > ADDED)
     */
    @CheckPermission("ADD_OUTLAY")
    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody OutlayDto outlayDto) {
        ApiResponse apiResponse = outlayService.add(outlayDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    /**
     * CHIQIMNI MALUMOTLARNI TAXRIRILASH
     *
     * @param id
     * @param outlayDto
     * @return ApiResponse(success - > true message - > EDITED)
     */
    @CheckPermission("EDIT_OUTLAY")
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody OutlayDto outlayDto) {
        ApiResponse apiResponse = outlayService.edit(id, outlayDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    /**
     * BITTA IDGA TEGISHLI CHIQIMNI OLIB CHIQISH
     *
     * @param id
     * @return ApiResponse(success - > true object - > value)
     */
    @CheckPermission("VIEW_OUTLAY")
    @GetMapping("/{id}")
    public HttpEntity<?> get(@PathVariable Integer id) {
        ApiResponse apiResponse = outlayService.get(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    /**
     * ID ORQALI BITTA CHIQIMNI DELETE QILSIH
     *
     * @param id
     * @return ApiResponse(success - > true message - > DELETED)
     */
    @CheckPermission("DELETE_OUTLAY")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = outlayService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    /**
     * KIRITLGAN SANADAGI VA BRANCHGA TEGISHLI CHIQIMNI OLIB CHIQISH
     *
     * @param date
     * @param branch_id
     * @return ApiResponse(success - > true message - > VALUE)
     */
    @CheckPermission("VIEW_OUTLAY")
    @GetMapping("/get-by-date/{date}/{branch_id}")
    public HttpEntity<?> getByDate(@PathVariable Date date, @PathVariable Integer branch_id) {
        ApiResponse apiResponse = outlayService.getByDate(date, branch_id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    /**
     * KIRITLGAN SANADAGI VA BUSINESSGA TEGISHLI CHIQIMNI OLIB CHIQISH
     *
     * @param date
     * @param
     * @return ApiResponse(success - > true message - > VALUE)
     */
    @CheckPermission("VIEW_OUTLAY")
    @GetMapping("/get-all-by-date/{business_id}/{date}")
    public HttpEntity<?> getByAllDate(@PathVariable Integer business_id, @PathVariable Date date) {
        ApiResponse apiResponse = outlayService.getAllByDate(date, business_id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    /**
     * BRANCHGA TEGISHLI CHIQMLARNI OLIB CHIQISH
     *
     * @param branch_id
     * @return ApiResponse(success - > true message - > VALUE)
     */
    @CheckPermission("VIEW_OUTLAY")
    @GetMapping("/get-by-branchId/{branch_id}")
    public HttpEntity<?> getAllByBranchId(@PathVariable Integer branch_id) {
        ApiResponse apiResponse = outlayService.getAllByBranchId(branch_id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    /**
     * BUSINESSGA TEGISHLI BARCHA CHIQIMLARNI OLIB CHQISH
     *
     * @param businessId
     * @return ApiResponse(success - > true message - > VALUE)
     */
    @CheckPermission("VIEW_OUTLAY_ADMIN")
    @GetMapping("/get-by-businessId/{businessId}")
    public HttpEntity<?> getAllByBusinessId(@PathVariable Integer businessId) {
        ApiResponse apiResponse = outlayService.getAllByBusinessId(businessId);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
