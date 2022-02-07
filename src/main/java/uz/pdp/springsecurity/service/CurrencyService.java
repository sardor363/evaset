package uz.pdp.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springsecurity.entity.Business;
import uz.pdp.springsecurity.entity.Currency;
import uz.pdp.springsecurity.payload.ApiResponse;
import uz.pdp.springsecurity.payload.CurrencyDto;
import uz.pdp.springsecurity.repository.BusinessRepository;
import uz.pdp.springsecurity.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    BusinessRepository businessRepository;

    public ApiResponse add(CurrencyDto currencyDto) {
        Optional<Business> optionalBusiness = businessRepository.findById(currencyDto.getBusinessId());
        if (optionalBusiness.isEmpty()) {
            return new ApiResponse("NOT FOUND BUSINESS", false);
        }
        Currency currency = new Currency(
                currencyDto.getName(),
                currencyDto.getCurrentCourse(),
                optionalBusiness.get()
        );
        currencyRepository.save(currency);
        return new ApiResponse("currency saved", true);
    }


    public ApiResponse edit(Integer id, CurrencyDto currencyDto) {
        if (!currencyRepository.existsById(id)) return new ApiResponse("currency not found", false);
        Optional<Business> optionalBusiness = businessRepository.findById(currencyDto.getBusinessId());
        if (optionalBusiness.isEmpty()) {
            return new ApiResponse("NOT FOUND BUSINESS", false);
        }
        Currency currency = currencyRepository.getById(id);
        currency.setBusiness(optionalBusiness.get());
        currency.setName(currencyDto.getName());
        currency.setCurrentCourse(currencyDto.getCurrentCourse());

        currencyRepository.save(currency);
        return new ApiResponse("CURRENCY EDITED", true);
    }

    public ApiResponse get(Integer id) {
        if (!currencyRepository.existsById(id)) return new ApiResponse("currency not found", false);
        return new ApiResponse("found", true, currencyRepository.findById(id).get());
    }


    public ApiResponse delete(Integer id) {
        if (!currencyRepository.existsById(id)) return new ApiResponse("currency not found", false);
        currencyRepository.deleteById(id);
        return new ApiResponse("currency deleted", true);
    }

    public ApiResponse getAllByBusinessId(Integer business_id) {
        List<Currency> allByBusiness_id = currencyRepository.findAllByBusiness_Id(business_id);
        if (allByBusiness_id.isEmpty()) return new ApiResponse("not found",false);
        return new ApiResponse("found",true,allByBusiness_id);
    }
}
