package com.example.myapplication.component.scopes

import javax.inject.Scope

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER)
@Scope
annotation class FragmentScope
