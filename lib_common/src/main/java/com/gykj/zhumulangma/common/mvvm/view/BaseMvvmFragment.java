package com.gykj.zhumulangma.common.mvvm.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;

import com.gykj.zhumulangma.common.mvvm.viewmodel.BaseViewModel;
import com.gykj.zhumulangma.common.status.InitCallback;


/**
 * Author: Thomas.
 * Date: 2019/9/10 8:23
 * Email: 1071931588@qq.com
 * Description:MvvmFragment基类
 */
public abstract class BaseMvvmFragment<VM extends BaseViewModel> extends BaseFragment {
    protected VM mViewModel;
    protected void initParam() {
        initViewModel();
        initBaseViewObservable();
        initViewObservable();
    }

    @Override
    protected void loadView() {
        super.loadView();
        mLoadService.showCallback(InitCallback.class);
    }

    protected void initViewModel() {
        mViewModel = createViewModel();
        getLifecycle().addObserver(mViewModel);
    }

    protected VM createViewModel(){
        return ViewModelProviders.of(this,onBindViewModelFactory()).get(onBindViewModel());
    }
    protected abstract Class<VM> onBindViewModel();
    protected abstract ViewModelProvider.Factory onBindViewModelFactory();
    protected abstract void initViewObservable();

    protected void initBaseViewObservable() {
        mViewModel.getShowInitViewEvent().observe(this, (Observer<Void>) show -> showInitView());
        mViewModel.getShowLoadingViewEvent().observe(this, (Observer<String>) tip -> showLoadingView(tip));
        mViewModel.getShowEmptyViewEvent().observe(this, (Observer<Void>) show -> showEmptyView());
        mViewModel.getShowErrorViewEvent().observe(this, (Observer<Void>) show -> showErrorView());
        mViewModel.getFinishSelfEvent().observe(this, (Observer<Void>) v -> pop());
        mViewModel.getClearStatusEvent().observe(this, (Observer<Void>) v -> clearStatus());
    }
}
