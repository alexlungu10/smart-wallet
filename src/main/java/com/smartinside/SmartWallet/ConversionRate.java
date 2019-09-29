package com.smartinside.SmartWallet;

import com.smartinside.SmartWallet.service.ConvertorServiceImpl;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@Builder
public class ConversionRate {
     String code;
     double rate;
}
