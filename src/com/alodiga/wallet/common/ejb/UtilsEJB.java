package com.alodiga.wallet.common.ejb;

import com.alodiga.wallet.common.exception.DuplicateEntryException;
import java.util.List;
import javax.ejb.Remote;
import com.alodiga.wallet.common.exception.EmptyListException;
import com.alodiga.wallet.common.exception.GeneralException;
import com.alodiga.wallet.common.exception.NullParameterException;
import com.alodiga.wallet.common.exception.RegisterNotFoundException;
import com.alodiga.wallet.common.genericEJB.EJBRequest;
import com.alodiga.wallet.common.genericEJB.WalletGenericEJB;
import com.alodiga.wallet.common.model.Bank;
import com.alodiga.wallet.common.model.BankOperation;
import com.alodiga.wallet.common.model.BankOperationMode;
import com.alodiga.wallet.common.model.BankOperationType;
import com.alodiga.wallet.common.model.BusinessAffiliationRequest;
import com.alodiga.wallet.common.model.BusinessCategory;
import com.alodiga.wallet.common.model.BusinessSubCategory;
import com.alodiga.wallet.common.model.BusinessType;
import com.alodiga.wallet.common.model.BusinessServiceType;
import com.alodiga.wallet.common.model.CalendarDays;
import com.alodiga.wallet.common.model.City;
import com.alodiga.wallet.common.model.Close;
import com.alodiga.wallet.common.model.CollectionType;
import com.alodiga.wallet.common.model.CollectionsRequest;
import com.alodiga.wallet.common.model.Commission;
import com.alodiga.wallet.common.model.CommissionItem;
import com.alodiga.wallet.common.model.Country;
import com.alodiga.wallet.common.model.County;
import com.alodiga.wallet.common.model.Currency;
import com.alodiga.wallet.common.model.Enterprise;
import com.alodiga.wallet.common.model.ExchangeRate;
import com.alodiga.wallet.common.model.Language;
import com.alodiga.wallet.common.model.OriginApplication;
import com.alodiga.wallet.common.model.Period;
import com.alodiga.wallet.common.model.PersonType;
import com.alodiga.wallet.common.model.Product;
import com.alodiga.wallet.common.model.RequestHasCollectionRequest;
import com.alodiga.wallet.common.model.ReviewBusinessAffiliationRequest;
import com.alodiga.wallet.common.model.ReviewOfac;
import com.alodiga.wallet.common.model.ReviewType;
import com.alodiga.wallet.common.model.Sequences;
import com.alodiga.wallet.common.model.Sms;
import com.alodiga.wallet.common.model.State;
import com.alodiga.wallet.common.model.StatusCard;
import com.alodiga.wallet.common.model.StatusCardHasFinalState;
import com.alodiga.wallet.common.model.StatusBusinessAffiliationHasFinalState;
import com.alodiga.wallet.common.model.StatusBusinessAffiliationRequest;
import com.alodiga.wallet.common.model.StatusTransactionApproveRequest;
import com.alodiga.wallet.common.model.Transaction;
import com.alodiga.wallet.common.model.TransactionApproveRequest;
import com.alodiga.wallet.common.model.TransactionType;
import java.util.Date;

@SuppressWarnings(value = {"all"})
@Remote
public interface UtilsEJB extends WalletGenericEJB {

    //City
    public List<City> getCitiesByCounty(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<City> getCitiesByState(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public City loadCity(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //County
    public List<County> getCountiesByState(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public County loadCounty(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Country
    public List<Country> getCountries(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<Country> getCountries() throws EmptyListException, GeneralException, NullParameterException;

    public Country loadCountry(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Country loadCountryByName(String name) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Country searchCountry(String name) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Country saveCountry(Country country) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Country loadCountryByShortName(String referenceCode) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    public List<Country> getSearchCountry(String name) throws EmptyListException, GeneralException, NullParameterException;
   
    public List<Country> getValidateCountryByCode(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    public List<Country> getValidateCountryByName(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
   
    //Currency
    public List<Currency> getCurrency(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<Currency> getCurrencies() throws EmptyListException, GeneralException, NullParameterException;

    public List<Currency> getSearchCurrency(String name) throws EmptyListException, GeneralException, NullParameterException;

    public Currency loadCurrency(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Currency saveCurrency(Currency currency) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Enterprise
    public List<Enterprise> getEnterprises(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<Enterprise> getEnterprises() throws EmptyListException, GeneralException, NullParameterException;

    public Enterprise loadEnterprisebyId(Long enterpriseId) throws GeneralException;

    public Enterprise loadEnterprise(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Enterprise saveEnterprise(EJBRequest request) throws NullParameterException, GeneralException;

    public void deleteEnterpriseHasTinType(Long enterpriseId) throws NullParameterException, GeneralException;

    //Language
    public List<Language> getLanguages() throws EmptyListException, GeneralException, NullParameterException;

    public Language loadLanguage(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Period
    public List<Period> getPeriods() throws EmptyListException, GeneralException, NullParameterException;

    public Period loadPeriod(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Period loadperiod(Period period) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //State
    public List<State> getStateByCountry(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public State loadState(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //SMS
    public Sms saveSMS(EJBRequest request) throws NullParameterException, GeneralException;

    //Bank
    public List<Bank> getBank(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public Bank loadBank(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Bank saveBank(Bank bank) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    public List<Bank> getSearchBank(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    public List<Bank> searchBankByCountry(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //ExchangeRate
    public List<ExchangeRate> getExchangeRate(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public ExchangeRate loadExchangeRate(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public ExchangeRate saveExchangeRate(ExchangeRate exchangeRate) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    public List<ExchangeRate> getExchangeRateByProductAndEndingDate(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    


    public ExchangeRate getExchangeRateByBeginningDate(Product productId,Date creationDate) throws EmptyListException, GeneralException, NullParameterException, RegisterNotFoundException;

    
    

    //Transaction
    public List<Transaction> getTransaction(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<Transaction> getTransactionByDates(Date beginningDate, Date endingDate) throws GeneralException, RegisterNotFoundException, NullParameterException, EmptyListException;

    public List<Transaction> getTransactionByBeginningDate(Date beginningDate) throws EmptyListException, GeneralException, NullParameterException;

    public Transaction loadTransaction(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Transaction saveTransaction(Transaction transaction) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Close
    public List<Close> getClose(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public Close loadClose(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Close saveClose(Close close) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //BankOperation
    public List<BankOperation> getBankOperationsByParams(EJBRequest request) throws NullParameterException, GeneralException, EmptyListException;

    public List<BankOperationType> getBankOperationTypes(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<BankOperationMode> getBankOperationModes(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<BankOperation> getBankOperations(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    //Commission
    public List<Commission> getCommission(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<Commission> getCommissionByProduct(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public Commission loadCommission(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Commission saveCommission(Commission commission) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public List<Commission> getCommissionByProductAndTranssactionType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //TransactionType
    public List<TransactionType> getTransactionType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public TransactionType loadTransactionType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public TransactionType saveTransactionType(TransactionType transactionType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public List<CommissionItem> getCommissionItems(Long transactionId) throws EmptyListException, GeneralException, NullParameterException;

    //CollectionType
    public List<CollectionType> getCollectionType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<CollectionType> getCollectionTypeByCountry(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    public List<CollectionType> getCollectionTypeByCountryByPersonType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public CollectionType loadCollectionType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public CollectionType saveCollectionType(CollectionType collectionType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public CollectionType searchCollectionType(String description) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public List<CollectionType> getSearchCollectionType(String name) throws EmptyListException, GeneralException, NullParameterException;

    //BusinessCategory
    public List<BusinessCategory> getBusinessCategory(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public BusinessCategory loadBusinessCategory(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public BusinessCategory saveBusinessCategory(BusinessCategory businessCategory) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    public List<BusinessCategory> getSearchBusinessCategory(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    public List<BusinessCategory> getValidateCodeMCC(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //BusinessSubCategory
    public List<BusinessSubCategory> getBusinessSubCategory(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<BusinessSubCategory> getBusinessSubCategoryByCategory(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public BusinessSubCategory loadBusinessSubCategory(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public BusinessSubCategory saveBusinessSubCategory(BusinessSubCategory businessSubCategory) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    public List<BusinessSubCategory> getSearchBusinessSubCategory(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    public List<BusinessSubCategory> getBusinessSubCategoryValidateCodeMCC(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //BusinessType
    public List<BusinessType> getBusinessType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public BusinessType saveBusinessType(BusinessType businessType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //BusinessServiceType
    public List<BusinessServiceType> getBusinessServiceType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<BusinessServiceType> getBusinessServiceTypeByBusinessType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public BusinessServiceType saveBusinessServiceType(BusinessServiceType businessServiceType) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<BusinessServiceType> getBusinessServiceTypeValidateCode(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //TransactionApproveRequest
    public List<TransactionApproveRequest> getTransactionApproveRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<TransactionApproveRequest> getTransactionApproveRequestByStatus(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public TransactionApproveRequest loadTransactionApproveRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public TransactionApproveRequest saveTransactionApproveRequest(TransactionApproveRequest transactionApproveRequest) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //StatusTransactionApproveRequest
    public List<StatusTransactionApproveRequest> getStatusTransactionApproveRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<StatusTransactionApproveRequest> getStatusTransactionApproveRequestPending(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public StatusTransactionApproveRequest loadStatusTransactionApproveRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public StatusTransactionApproveRequest saveStatusTransactionApproveRequest(StatusTransactionApproveRequest statusTransactionApproveRequest) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //BankOperation
    public List<BankOperation> getBankOperation(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public BankOperation loadBankOperation(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public BankOperation saveBankOperation(BankOperation bankOperation) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //CollectionsRequest
    public List<CollectionsRequest> getCollectionsRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<CollectionsRequest> getCollectionsByPersonType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<CollectionsRequest> getCollectionsRequestByID(CollectionsRequest collectionsRequest) throws GeneralException, EmptyListException, NullParameterException;

    public CollectionsRequest loadCollectionsRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public CollectionsRequest saveCollectionsRequest(CollectionsRequest collectionsRequest) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //StatusBusinessAffiliationRequest
    public List<StatusBusinessAffiliationRequest> getStatusBusinessAffiliationRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public StatusBusinessAffiliationRequest loadStatusBusinessAffiliationRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public StatusBusinessAffiliationRequest saveStatusBusinessAffiliationRequest(StatusTransactionApproveRequest statusTransactionApproveRequest) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //StatusBusinessAffiliationHasFinalState
    public List<StatusBusinessAffiliationHasFinalState> getStatusBusinessAffiliationHasFinalState(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public StatusBusinessAffiliationHasFinalState loadStatusBusinessAffiliationHasFinalState(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public StatusBusinessAffiliationHasFinalState saveStatusBusinessAffiliationHasFinalState(StatusBusinessAffiliationHasFinalState statusBusinessAffiliationHasFinalState) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public boolean validateStatusBusinessAffiliationHasFinalState(Integer statusId, Integer finalId) throws GeneralException, NullParameterException;

    //BusinessAffiliationRequest
    public List<BusinessAffiliationRequest> getBusinessAffiliationRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public BusinessAffiliationRequest loadBusinessAffiliationRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public BusinessAffiliationRequest saveBusinessAffiliationRequest(BusinessAffiliationRequest businessAffiliationRequest) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //ReviewBusinessAffiliationRequest
    public List<ReviewBusinessAffiliationRequest> getReviewBusinessAffiliationRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<ReviewBusinessAffiliationRequest> getReviewBusinessRequestByRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public ReviewBusinessAffiliationRequest loadReviewBusinessAffiliationRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public ReviewBusinessAffiliationRequest saveReviewBusinessAffiliationRequest(ReviewBusinessAffiliationRequest reviewBusinessAffiliationRequest) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //RequestHasCollectionsRequest
    public List<RequestHasCollectionRequest> getRequestsHasCollectionsRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public RequestHasCollectionRequest loadRequestHasCollectionsRequest(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public RequestHasCollectionRequest saveRequestHasCollectionsRequest(RequestHasCollectionRequest requestHasCollectionsRequest) throws NullParameterException, GeneralException;

    public List<RequestHasCollectionRequest> getRequestsHasCollectionsRequestByRequestByCollectionRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<RequestHasCollectionRequest> getRequestsHasCollectionsRequestByBusinessAffiliationRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public void updateBusinessAffiliationRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public StatusBusinessAffiliationRequest loadStatusBusinessAffiliationRequestByCode(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException, EmptyListException;
    
    //PersonType
    public PersonType savePersonType (PersonType personType)  throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    public List<PersonType> getPersonType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    public List<PersonType> getPersonTypeByCountryByIndNaturalPerson(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    public List<PersonType> getPersonTypeByCountryByOriginApplication(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    public List<PersonType> getSearchPersonTypeByCountry(String name) throws EmptyListException, GeneralException, NullParameterException;
    
    //ReviewOfac
    public List<ReviewOfac> getReviewOfac(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<ReviewOfac> getReviewOfacByRequest(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public ReviewOfac loadReviewOfac(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public ReviewOfac saveReviewOfac(ReviewOfac reviewOfac) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //ReviewType
    public List<ReviewType> getReviewType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public ReviewType loadReviewType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public ReviewType saveReviewType(ReviewType reviewType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //StatusCard
    public List<StatusCard> getStatusCard(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public StatusCard saveStatusCard(StatusCard statusCard) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //StatusCardHasFinalState
    public List<StatusCardHasFinalState> getStatusCardHasFinalState(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public List<StatusCardHasFinalState> getStatusCardById(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public boolean validateStatusCardHasFinalState(Integer statusId, Integer finalId) throws GeneralException, NullParameterException;

    public StatusCardHasFinalState saveStatusCardHasFinalState(StatusCardHasFinalState statusCardHasFinalState) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //OriginApplication
    public List<OriginApplication> getOriginApplications(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    public OriginApplication loadOriginApplicationByCode(EJBRequest request)throws RegisterNotFoundException, NullParameterException, GeneralException, EmptyListException;

    //Sequences
    public List<Sequences> getSequences(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    public List<Sequences> getSequencesByDocumentType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    public Sequences loadSequences(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public Sequences saveSequences(Sequences sequences) throws RegisterNotFoundException, NullParameterException, GeneralException;

    public String generateNumberSequence(List<Sequences> sequence, int originApplication) throws GeneralException, RegisterNotFoundException, NullParameterException;
    
    public Country saveNewCountry(Country country) throws RegisterNotFoundException, GeneralException, NullParameterException, DuplicateEntryException;
    
    //Calendar Days
    public List<CalendarDays> getCalendarDays(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CalendarDays saveCalendarDays(CalendarDays calendarDays) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    public Long loadTransactionTypeById(Long TransactionTypeId) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
}
