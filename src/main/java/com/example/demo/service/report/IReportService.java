package com.example.demo.service.report;

import com.example.demo.entity.Payment;

import java.util.List;

public interface IReportService {
    List<Payment> findAll();
}
