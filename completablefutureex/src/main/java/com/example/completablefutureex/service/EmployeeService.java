package com.example.completablefutureex.service;

import com.example.completablefutureex.entity.Employee;
import com.example.completablefutureex.repository.EmployeeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> addAllEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesWithSupplyAsync() throws ExecutionException, InterruptedException {

        //  Executor executor= Executors.newFixedThreadPool(5);
        CompletableFuture<List<Employee>> completableFuture=
                CompletableFuture.supplyAsync(()->{
                    System.out.println("Executed By :"+Thread.currentThread().getName());
                    return employeeRepository.findAll();
                });
        return completableFuture.get();
    }

    public List<Employee> getEmployeesWithSupplyAsyncAndCustomExecutor() throws ExecutionException, InterruptedException {

          Executor executor= Executors.newFixedThreadPool(5);
        CompletableFuture<List<Employee>> completableFuture=
                CompletableFuture.supplyAsync(()->{
                    System.out.println("Executed By :"+Thread.currentThread().getName());
                    return employeeRepository.findAll();
                },executor);
        return completableFuture.get();
    }

    public Void addAllEmployeesWithRunAsync(List<Employee> employees) throws ExecutionException, InterruptedException {
        Executor executor= Executors.newFixedThreadPool(5);
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
            employeeRepository.saveAll(employees);
                System.out.println("Thread: " + Thread.currentThread().getName());
        },executor);
        return runAsyncFuture.get();
    }
}
