package com.gallery.exhibition.api;

import com.gallery.exhibition.*;
import com.gallery.exhibition.model.Exhibition;
import com.gallery.exhibition.service.ExhibitionService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@GRpcService
public class ExhibitionGrpcController extends ExhibitionServiceGrpc.ExhibitionServiceImplBase {

    @Autowired
    private ExhibitionService exhibitionService;

    @Override
    public void all(AllExhibitionsRequest request, StreamObserver<AllExhibitionsResponse> responseObserver) {
        List<Exhibition> exhibitions = exhibitionService.getAll();
        List<ExhibitionResponse> convertedExhibitions = exhibitions.stream().
                map(Exhibition::toExhibitionResponse).
                collect(Collectors.toList());
        AllExhibitionsResponse response = AllExhibitionsResponse.newBuilder().
                addAllExhibitions(convertedExhibitions).
                build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void add(ExhibitionRequest request, StreamObserver<ExhibitionResponse> responseObserver) {
        Exhibition exhibition = exhibitionService.addExhibition(Exhibition.fromExhibitionRequest(request));
        responseObserver.onNext(exhibition.toExhibitionResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void byId(ExhibitionByIdRequest request, StreamObserver<ExhibitionResponse> responseObserver) {
        Exhibition exhibition = exhibitionService.getById(UUID.fromString(request.getId()));
        responseObserver.onNext(exhibition.toExhibitionResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void delete(ExhibitionByIdRequest request, StreamObserver<DeleteExhibitionResponse> responseObserver) {
        exhibitionService.deleteById(UUID.fromString(request.getId()));
        responseObserver.onNext(DeleteExhibitionResponse.newBuilder().build());
        responseObserver.onCompleted();
    }
}
