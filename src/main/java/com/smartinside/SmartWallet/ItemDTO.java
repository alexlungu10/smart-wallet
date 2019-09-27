package com.smartinside.SmartWallet;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
@Builder(toBuilder = true)
public class ItemDTO {
    String imageName;
    String descr;
    String operation;
    String currency;
}
