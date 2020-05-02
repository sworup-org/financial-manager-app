package com.poc.FinancialManager.services;

import com.itextpdf.text.DocumentException;
import com.poc.FinancialManager.Utility.ChartGenerator;
import com.poc.FinancialManager.Utility.PdfPrinter;
import com.poc.FinancialManager.model.ExpenditureModel;
import com.poc.FinancialManager.model.FInancialModel;
import com.poc.FinancialManager.model.IncomeModel;
import com.poc.FinancialManager.model.SavingsModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@Service
public class FinancialModelServiceImpl implements FInancialModelService {

    @Autowired
    SavingsService savingsService;
    @Autowired
    IncomeService incomeService;
    /*@Autowired
    ExpenditureService expenditureService;*/




    @Transactional
    @Override
    public FInancialModel getFinancialModelOfUser(String userId) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<IncomeModel> incomeModels;
        List<ExpenditureModel> expenditureModels=new ArrayList<>();

        int totalIncome=0,totalExpenditure=0;

        Query query = session.createQuery("from SavingsModel sm where userId = :userId order by sm.savingsDate DESC", SavingsModel.class);
        query.setParameter("userId",userId);
        query.setMaxResults(1);
        SavingsModel savingslast = (SavingsModel) query.uniqueResult();

        query = session.createQuery("from IncomeModel im where userId = :userId order by im.incomeDate DESC", IncomeModel.class);
        query.setParameter("userId",userId);
        incomeModels=query.getResultList();

        query = session.createQuery("from ExpenditureModel im where userId = :userId order by im.expenseDate DESC", ExpenditureModel.class);
        query.setParameter("userId",userId);
        expenditureModels=query.getResultList();

         totalIncome=incomeModels.stream().mapToInt(x->x.getTotalIncome()).sum();
         totalExpenditure=expenditureModels.stream().mapToInt(x->x.getTotalExpense()).sum();

        FInancialModel fInancialModel=new FInancialModel();
        fInancialModel.setUserId(userId);
        fInancialModel.setIncomeModel(incomeModels);
        fInancialModel.setExpenditureModel(expenditureModels);
        fInancialModel.setSavingsModel(savingslast);
        fInancialModel.setTotalExpense(totalExpenditure);
        fInancialModel.setTotalIncome(totalIncome);
        ChartGenerator chartGenerator=new ChartGenerator();
        try {
            if(!(fInancialModel.getIncomeModel().isEmpty()||fInancialModel.getExpenditureModel().isEmpty())) {
                chartGenerator.chartGeneratorForModel(fInancialModel);
                generateFinancialModelPDF(fInancialModel);
            }
            }
        catch (Exception e)
        {
            System.out.print("PDF GENERATOR FOR THE MODEL FAILED");
            e.printStackTrace();
        }

        
        return fInancialModel;

    }

    private void generateFinancialModelPDF(FInancialModel fInancialModel) throws DocumentException, IOException, URISyntaxException {

        PdfPrinter pdfPrinter=new PdfPrinter();
        pdfPrinter.pdfConverterForModel(fInancialModel);

    }
}
