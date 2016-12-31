# Support Design Library

# Material Design
**Google I/O 2014** 최초 발표.  
**Material Design은 플랫폼 및 기기 전반의 표현 방식, 모션 및 상호 작용 디자인에 대한 종합적인 지침.**

![](http://dl.dropbox.com/s/44bwhbricbrjkd1/MaterialDesign0.png)  
![](http://dl.dropbox.com/s/dx4jqoulysucfq4/MaterialDesign1.png)  

## AppCompat
AppCompat은 Material Design을 기초로 안드로이드 어플리케이션을 위한 일관된 기반을 지원한다.  
**하위 호환성** 고려한 Library

## Support Design Library - API 7 ↑
아름다운 안드로이드 어플리케이션 개발, Material Design과 잘 어울리는 많은 고급 구성요소를 지원한다.

## Site
https://developer.android.com/design/material/index.html?hl=ko  
https://developers-kr.googleblog.com/2015/06/designsupport.html  
https://material.io/guidelines/#introduction-principles  
http://www.kmshack.kr/tag/coordinatorlayout/

## Gradle for Support Design Library
``build.gradle (Module: app Level)``

```java
dependencies {
    // Android Support Design Library dependency
    compile 'com.android.support:design:25.0.0'
    .....
}
```

-----

# Content

## Visual
* ``TabLayout``  
  최상위 Navigation or Grouping Content  
  Material Design 기반의 Tab  
  고정 Tab, Tab의 각 항목의 폭 균등 분할, Scrolling Tab 지원.  
  ``TabLayout``, ``ViewPager`` 간 쉬운 Sync을 위한 Listener 지원.  
  ![](http://dl.dropbox.com/s/dhsmlw7vpszkdh4/TabLayout.png)

* ``NavigationDrawer (NavigationView)``  
  최상위 Navigation or Grouping Content  
  ``NavigationView``는 완벽하게 디자인 된 서랍  
  Header View로 머리말을 입력하거나, Menu Resource File로 탐색 항목 추가 가능.    
  ``checkableBehavior="single"`` 속성으로 확인한 항목이 강조되어 표현 가능.  
  SubView로 작은 표제 사용 가능.  
  ![](http://dl.dropbox.com/s/0ukr7jdvm492kxt/NavigationDrawer.png)  


* ``TextInputLayout``  
  Hint, Error Text를 위한 Label을 띄우는 Layout  
  ![](http://dl.dropbox.com/s/hi6xcnai8mtwavh/TextInputLayout.png)

* ``FloatingActionButton``  
  UI 기본 동작을 위한 항상 띄우는 Button  
  ![](http://dl.dropbox.com/s/82o8jx5eajzvaq6/FloatingActionButton.png)

* ``SnackBar``    
  Quick Lightweight Feedback Message  
  Toast와 달리 Option 추가 가능, Swipe로 SnackBar 무시 가능.

## Motion
* ``CoordinatorLayout``    
  ``CoordinatorLayout``은 ``Behavior`` 를 통해 Child View 간 Touch Event에 대한 추가 수준의 제어 지원  
  ![](http://dl.dropbox.com/s/cxzmam9kedrvpiz/CoordinatorLayout.gif)

* ``AppBarLayout``    
  ``Toolbar``, 기타 View가 ``ScrollingViewBehavior``로 표시된 형제 View의 Scroll Event로 반응하도록 설계

* ``CollapsingToolbarLayout``  
  Text Size, pinning and parallax  
  확장된 높이의 ``Toolbar``를 접으면 Title Size 조정 가능.  
  접을 수 있는 ``Toobar`` 위로 항목을 고정시키거나, 변화하는 이미지를 넣거나, 접히면 원색 표현 가능.  
  ![](http://dl.dropbox.com/s/dm06h63oj14wh4k/CollapsingToolbarLayout.gif)

-----

# Material Design Motion ``CoordinatorLayout``
``CoordinatorLayout``은 Super-Powered FrameLayout with **Coordinator Motion**    
초기 ``AppBar``가 Main Content의 Scroll 반응과 연동되는 것을 목적으로 출시.

``CoordinatorLayout``은 다음과 같은 두 가지 주요 사례를 대상으로 한다.

1. 최상위 레벨 어플리케이션 데코레이션 또는 크롬 레이아웃
2. 하나 이상의 Child View와 특정 상호 작용을 위한 Container

**CoordinatorLayout's Characteristic**

1. Child View는 각각 자신의 ``Behavior`` 지정, 터치하면서 추가적인 Control과 View들의 Dependency 조정  
2. 다양한 방법으로 Child View들의 위치 할당

-----

# ``CoordinatorLayout``'s XML Attribute

## Scrolling Technique ``app:layout_scrollFlags``
``CoordinatorLayout``의 또 다른 주요한 사례로 **AppBar(Toolbar) Scrolling** 기능이 있다.   
Design Library는 이 기능을 한 단계 더 발전시켰다.

``AppBarLayout`` 으로 ``Toolbar``와 기타 View가 ``ScrollingViewBehavior``로 표시된   
형제 View에서 일어난 Scroll Event에 반응하도록 할 수 있다.

Flag                | Description                                                                    |
--------------------|--------------------------------------------------------------------------------|
scroll              |**UI 화면 밖으로 Scroll로 내보내고자 하는 모든 View에 반드시 설정** 이 Flag를 사용하지 않는 View는 UI 화면 가장 위에 고정된 상태로 유지  
enterAlways         |아래쪽 방향으로 Scroll 시, 항상 이 View가 표시되며 'Quick Return' Pattern 활성화  
enterAlwaysCollapsed|View가 minHeight를 선언한 경우, View가 최소 높이로만 진입하게 되고('축소됨') Scrolling View가 가장 위로 도달했을 때만 전체 높이로 다시 확장  
exitUntilCollapsed  |View가 '축소됨'(minHeight) 크기로 도달 시까지 밖으로 Scroll 되다가 종료  

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

    <android.support.design.widget.AppBarLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

        <android.support.v7.widget.Toolbar
              ...
              app:layout_scrollFlags="scroll|enterAlways">


        <android.support.design.widget.TabLayout
              ...
              app:layout_scrollFlags="scroll|enterAlways">

    </android.support.design.widget.AppBarLayout>

    <! -- Your Scrollable View -->
    <android.support.v7.widget.RecyclerView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layout_behavior="@string/appbar_scrolling_view_behavior" />

</android.support.design.widget.CoordinatorLayout>
```

**``RecyclerView``를 Scroll 하면 ``AppBarLayout``이 Touch Event에 응답!**  
이 때, Scroll Flag를 지정하고 진입(화면 안으로 스크롤)과 종료(화면 밖으로 스크롤) 방식을 Control.    
Scroll Flags는 Quick Pattern을 단 몇 줄의 XML로 실현.  

**참고!**  
Scroll Flag를 사용하는 모든 View는 이 Flag를 사용하지 않는 View 보다 반드시 먼저 선언.   
모든 View가 가장 위쪽부터 종료되고 고정된 요소를 남겨두도록 보장할 수 있다.

## ``Behavior``
**``CoordinatorLayout``의 Child View에 대한 ``Behavior`` 지정으로 단일 Parent, View 간 다양한 상호 작용 가능.**  
``Behavior``를 사용하면 Drawer 및 Panel을 밀어 넣는 것과 이동 가능하고 Amimation으로 움직이면,    
다른 View 요소에 달라 붙는 스와이프 기능까지 다양한 상호 작용 및 추가 레이아웃 수정을 구현할 수 있다.

``Coordinator.Behavior`` 추가 API 지원으로 하위 View가 Touch Event. Gesture를 Control 가능하고       
서로 간의 Dependency를 선언하고 ``onDependentViewChanged()`` Method로 Callback 받을 수 있다.   

View가 기본 동작을 선언하려면 ``@CoordinatorLayout.DefaultBehavior(YourView.Behavior.class)``,
``app:layout_behavior="com.example.app.YourView$Behavior"`` 특성으로 XML Layout 파일에 설정.   
이 프레임워크로 어느 View라도 ``CoordinatorLayout``과 통합 가능.

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fitsSystemWindows="true">

    <android.support.design.widget.AppBarLayout
        android:id="@+id/app_bar"
        android:layout_width="match_parent"
        android:layout_height="@dimen/app_bar_height"
        android:fitsSystemWindows="true"
        android:theme="@style/AppTheme.AppBarOverlay">

        <android.support.design.widget.CollapsingToolbarLayout
            android:id="@+id/toolbar_layout"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:fitsSystemWindows="true"
            app:contentScrim="?attr/colorPrimary"
            app:layout_scrollFlags="scroll|exitUntilCollapsed">

            <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                app:layout_collapseMode="pin"
                app:popupTheme="@style/AppTheme.PopupOverlay" />

        </android.support.design.widget.CollapsingToolbarLayout>

    </android.support.design.widget.AppBarLayout>

    <android.support.v4.widget.NestedScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_behavior="android.support.design.widget.AppBarLayout$ScrollingViewBehavior">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="@dimen/text_margin"
            android:text="@string/large_text" />

    </android.support.v4.widget.NestedScrollView>

</android.support.design.widget.CoordinatorLayout>
```

#### ``NestedScrollView``
``NestedScrollView``의 ``layout_behavior``는 ``AppBarLayout$ScrollingViewBehavior``가 미리 정의됨.      
``NestedScrollView``의 반응에 따라 ``AppBarLayout``이 반응.  

``CoordinatorLayout``는 ``NestedScrollView``가 Scroll 되면 ``layout_behavior``로 정의된 레이아웃으로   
Scroll 정보를 전달 하는 역할. 그럼 ``AppBarLayout``의 ``ScrollingViewBehavior`` 정보로 ``AppBarLayout``   
자신을 변형하도록 하는 구조.

``CoordinatorLayout``이 Scroll 되는 것은 ``Behavior``에 구현된 **``NestedScrollingParent``** 로 전달.     
``CoordinatorLayout``는 ``NestedScrollingParent``가 구현되어 있으며, Scroll 되는 View들은   
``NestedScrollingChild``가 구현되어 있어야 ``Behavior``가 전달.   

## ``Anchor``
**특정 View의 ``Anchor``를 달아 고정하고 함께 이동함.**  
``Anchor``를 고정하는 위치 및 기준 지정 가능.

-----

# Let's Coding

## 1. Add ``activity_main.xml`` Top-Level View ``CoordinatorLayout``

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.kitkat.android.coodinatorlayout.MainActivity">

</android.support.design.widget.CoordinatorLayout>
```

## 2. Add Child View ``AppBarLayout`` → ``Toolbar``, ``RecyclerView``

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.kitkat.android.coodinatorlayout.MainActivity">

    <android.support.design.widget.AppBarLayout
      android:layout_width="match_parent"
      android:layout_height="wrap_content" >

      <android.support.v7.widget.Toolbar
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:minHeight="?attr/actionBarSize"
            android:id="@+id/toolbar" />

    </android.support.design.widget.AppBarLayout>

    <android.support.v7.widget.RecyclerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/recycler">

</android.support.design.widget.CoordinatorLayout>
```

## 3. Add ``android:theme``, ``app:popupTheme``, ``app:layout_scrollFlags`` Attribute

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    tools:context="com.kitkat.android.coodinatorlayout.MainActivity">

    <android.support.design.widget.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar">

        <android.support.v7.widget.Toolbar
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:minHeight="?attr/actionBarSize"
            app:popupTheme="@style/ThemeOverlay.AppCompat.Light"
            app:layout_scrollFlags="scroll|enterAlways"
            android:id="@+id/toolbar" />

    </android.support.design.widget.AppBarLayout>

    <android.support.v7.widget.RecyclerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/recycler">

    </android.support.v7.widget.RecyclerView>
</android.support.design.widget.CoordinatorLayout>
```

## 4. Change res/style's ``AppTheme`` → ``NoActionBar``

```xml
<resources>

    <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>

</resources>
```

## 5. Add ``Behavior`` for Scrolling information Providing to ``AppBarLayout``
```xml
<android.support.v7.widget.RecyclerView
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:id="@+id/recycler"
       app:layout_behavior="@string/appbar_scrolling_view_behavior">
```
