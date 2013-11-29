package com.eshop.service.impl;

import org.springframework.stereotype.Component;

import com.base.framwork.service.EntityService;
import com.eshop.service.IProductViewService;
import com.eshop.view.ProductViewModel;

@Component
public class ProductViewService extends EntityService<ProductViewModel> implements IProductViewService {

}
