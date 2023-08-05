package pl.kwisniewska.web;

import pl.kwisniewska.model.Claim;
import pl.kwisniewska.model.DailyRate;
import pl.kwisniewska.model.MileageRate;
import pl.kwisniewska.model.Receipt;
import pl.kwisniewska.model.ReceiptType;
import pl.kwisniewska.service.DailyRateService;
import pl.kwisniewska.service.MileageRateService;
import pl.kwisniewska.service.ReceiptService;
import pl.kwisniewska.service.ReceiptTypeService;
import pl.kwisniewska.service.impl.ClaimServiceImpl;
import pl.kwisniewska.service.impl.DailyRateServiceImpl;
import pl.kwisniewska.service.impl.MileageRateServiceImpl;
import pl.kwisniewska.service.impl.ReceiptServiceImpl;
import pl.kwisniewska.service.impl.ReceiptTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/claim/new")
public class NewClaimServlet extends HttpServlet {

    private final ReceiptTypeService receiptTypeService = new ReceiptTypeServiceImpl();
    private final ReceiptService receiptService = new ReceiptServiceImpl();
    private final DailyRateService dailyRateService = new DailyRateServiceImpl();
    private final MileageRateService mileageRateService = new MileageRateServiceImpl();
    private final ClaimServiceImpl claimCalculator = new ClaimServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ReceiptType> receiptTypes = receiptTypeService.getAllReceiptTypes();
        req.setAttribute("receiptTypes", receiptTypes);

        DailyRate dailyRate = dailyRateService.getDailyRate();
        req.setAttribute("dailyRate", dailyRate.getValue());

        MileageRate mileageRate = mileageRateService.getMileageRate();
        req.setAttribute("mileageRate", mileageRate.getValue());

        getServletContext().
                getRequestDispatcher("/WEB-INF/newClaim.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] types = req.getParameterValues("type");
        String[] amounts = req.getParameterValues("amount");
        List<Receipt> receipts = receiptService.parseFormFieldsToReceiptList(types, amounts);

        int travelDays = Integer.parseInt(req.getParameter("travelDays"));
        int carMileage = Integer.parseInt(req.getParameter("carMileage"));

        Claim claim = new Claim(receipts, travelDays, carMileage);
        Double totalReimbursement = claimCalculator.calculateTotalReimbursement(claim);

        getServletContext().
                getRequestDispatcher("/WEB-INF/claimSummary.jsp").forward(req, resp);
    }
}
