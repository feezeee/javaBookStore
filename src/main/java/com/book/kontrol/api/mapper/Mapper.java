package com.book.kontrol.api.mapper;

import com.book.kontrol.api.request.book_controller.PostBookRequest;
import com.book.kontrol.api.request.book_controller.PutBookRequest;
import com.book.kontrol.api.request.category_controller.PostCategoryRequest;
import com.book.kontrol.api.request.category_controller.PutCategoryRequest;
import com.book.kontrol.api.response.book_controller.GetBookResponse;
import com.book.kontrol.api.response.category_controller.GetCategoryResponse;
import com.book.kontrol.bll.models.input.book.CreateBookInput;
import com.book.kontrol.bll.models.input.book.UpdateBookInput;
import com.book.kontrol.bll.models.input.category.CreateCategoryInput;
import com.book.kontrol.bll.models.input.category.UpdateCategoryInput;
import com.book.kontrol.bll.models.output.book.GetBookOutput;
import com.book.kontrol.bll.models.output.category.GetCategoryOutput;

public class Mapper {
    public CreateBookInput toCreateBookInput(PostBookRequest postBookRequest){
        if(postBookRequest == null)
        {
            return null;
        }
        var book = new CreateBookInput();
        book.name = postBookRequest.name;
        book.count = postBookRequest.count;
        book.description = postBookRequest.description;
        book.price = postBookRequest.price;
        return book;
    }

    public UpdateBookInput toUpdateBookInput(PutBookRequest putBookRequest){
        if(putBookRequest == null)
        {
            return null;
        }
        var book = new UpdateBookInput();
        book.id = putBookRequest.id;
        book.name = putBookRequest.name;
        book.count = putBookRequest.count;
        book.description = putBookRequest.description;
        book.price = putBookRequest.price;
        return book;
    }
    public GetBookResponse toGetBookResponse(GetBookOutput getBookOutput){
        if(getBookOutput == null)
        {
            return null;
        }
        var book = new GetBookResponse();
        book.id = getBookOutput.id;
        book.name = getBookOutput.name;
        book.count = getBookOutput.count;
        book.description = getBookOutput.description;
        book.price = getBookOutput.price;
        return book;
    }


    public CreateCategoryInput toCreateCategoryInput(PostCategoryRequest postCategoryRequest) {
        if (postCategoryRequest == null) {
            return null;
        }
        var createCategoryInput = new CreateCategoryInput();
        createCategoryInput.name = postCategoryRequest.name;
        return createCategoryInput;
    }
    public UpdateCategoryInput toUpdateCategoryInput(PutCategoryRequest putCategoryRequest){
        if(putCategoryRequest == null)
        {
            return null;
        }
        var updateCategoryInput = new UpdateCategoryInput();
        updateCategoryInput.id = putCategoryRequest.id;
        updateCategoryInput.name = putCategoryRequest.name;
        return updateCategoryInput;
    }
    public GetCategoryResponse toGetCategoryResponse(GetCategoryOutput getCategoryOutput){
        if(getCategoryOutput == null)
        {
            return null;
        }
        var getCategoryResponse = new GetCategoryResponse();
        getCategoryResponse.id = getCategoryOutput.id;
        getCategoryResponse.name = getCategoryOutput.name;
        return getCategoryResponse;
    }
}
