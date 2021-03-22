package com.example.demo.service.report;

import com.example.demo.entity.Payment;
import com.example.demo.repository.IPaymentRepository;
import com.example.demo.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService implements IReportService {
    @Autowired
    private IPaymentService paymentService;

    @Override
    public List<Payment> findAll() {
        return paymentService.findAll();
    }
}
