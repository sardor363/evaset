package uz.pdp.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springsecurity.entity.PaymentMethod;
import uz.pdp.springsecurity.payload.ApiResponse;
import uz.pdp.springsecurity.payload.PayMethodDto;
import uz.pdp.springsecurity.repository.PayMethodRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PayMethodService {
    @Autowired
    PayMethodRepository payMethodRepository;


    public ApiResponse add(PayMethodDto payMethodDto) {
        boolean b = payMethodRepository.existsByType(payMethodDto.getType());
        if (b) return new ApiResponse("such a payment method already exists",false);

        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setType(payMethodDto.getType());

        payMethodRepository.save(paymentMethod);
        return new ApiResponse("saved",true);
    }

    public ApiResponse edit(Integer id, PayMethodDto payMethodDto) {
        Optional<PaymentMethod> optional = payMethodRepository.findById(id);
        if (!optional.isPresent()) return new ApiResponse("not found",false);

        boolean b = payMethodRepository.existsByType(payMethodDto.getType());
        if (b) return new ApiResponse("such a payment method already exists",false);

        PaymentMethod paymentMethod = payMethodRepository.getById(id);
        paymentMethod.setType(payMethodDto.getType());

        payMethodRepository.save(paymentMethod);
        return new ApiResponse("edited",true);
    }

    public ApiResponse get(Integer id) {
        if (!payMethodRepository.existsById(id)) return new ApiResponse("not found",false);
        return new ApiResponse("found",true,payMethodRepository.findById(id).get());
    }

    public ApiResponse delete(Integer id) {
        if (!payMethodRepository.existsById(id)) return new ApiResponse("not found",false);

        payMethodRepository.deleteById(id);
        return new ApiResponse("deleted",true);
    }

    public ApiResponse getAllByBranch(Integer branch_id) {
        List<PaymentMethod> allByBranch_id = payMethodRepository.findAllByBranch_Id(branch_id);
        if (allByBranch_id.isEmpty()) return new ApiResponse("NOT FOUND",false);
        return new ApiResponse("FOUND",true,allByBranch_id);
    }

    public ApiResponse getAllByBusiness(Integer business_id) {
        List<PaymentMethod> allByBranch_business_id = payMethodRepository.findAllByBranch_Business_Id(business_id);
        if (allByBranch_business_id.isEmpty()) return new ApiResponse("not found",false);
        return new ApiResponse("found",true,allByBranch_business_id);
    }
}
