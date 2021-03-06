package com.maxmind.minfraud.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maxmind.minfraud.AbstractModel;

/**
 * This class contains minFraud response data related to the credit card.
 */
public final class CreditCard extends AbstractModel {
    private final Issuer issuer;
    private final String brand;
    private final String country;
    private final Boolean isIssuedInBillingAddressCountry;
    private final Boolean isPrepaid;
    private final Boolean isVirtual;
    private final String type;

    // This method is for backwards compatibility. We should remove it when we
    // do a major release.
    public CreditCard(
            String brand,
            String country,
            Boolean isIssuedInBillingAddressCountry,
            Boolean isPrepaid,
            Issuer issuer,
            String type
    ) {
        this(brand, country, isIssuedInBillingAddressCountry, isPrepaid, false,
            issuer, type);
    }

    public CreditCard(
            @JsonProperty("brand") String brand,
            @JsonProperty("country") String country,
            @JsonProperty("is_issued_in_billing_address_country") Boolean isIssuedInBillingAddressCountry,
            @JsonProperty("is_prepaid") Boolean isPrepaid,
            @JsonProperty("is_virtual") Boolean isVirtual,
            @JsonProperty("issuer") Issuer issuer,
            @JsonProperty("type") String type
    ) {
        this.brand = brand;
        this.country = country;
        this.isIssuedInBillingAddressCountry = isIssuedInBillingAddressCountry;
        this.isPrepaid = isPrepaid;
        this.isVirtual = isVirtual;
        this.issuer = issuer == null ? new Issuer() : issuer;
        this.type = type;
    }

    public CreditCard() {
        this(null, null, null, null, null, null, null);
    }

    /**
     * @return The {@code Issuer} model object.
     */
    public Issuer getIssuer() {
        return issuer;
    }

    /**
     * @return The credit card brand.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @return The two letter <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">
     * ISO 3166-1 alpha-2</a> country code associated with the location
     * of the majority of customers using this credit card as determined
     * by their billing address. In cases where the location of customers
     * is highly mixed, this defaults to the country of the bank issuing
     * the card.
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return True if the country of the billing address matches the country
     * of the majority of customers using that IIN. In cases where the
     * location of customers is highly mixed, the match is to the country of
     * the bank issuing the card.
     */
    @JsonProperty("is_issued_in_billing_address_country")
    public Boolean isIssuedInBillingAddressCountry() {
        return isIssuedInBillingAddressCountry;
    }

    /**
     * @return True if the card is a prepaid card. False if not prepaid. If
     * the IIN was not provided or is unknown, null will be returned.
     */
    @JsonProperty("is_prepaid")
    public Boolean isPrepaid() {
        return isPrepaid;
    }

    /**
     * @return True if the card is a virtual card. False if not virtual. If the
     * IIN was not provided or is unknown, null will be returned.
     */
    @JsonProperty("is_virtual")
    public Boolean isVirtual() {
        return isVirtual;
    }

    /**
     * @return The credit card type.
     */
    public String getType() {
        return type;
    }
}
