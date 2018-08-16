package qs.recipe.controllers;

import qs.recipe.domain.Recipe;
import qs.recipe.services.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



public class IndexControllerTest {

    private  IndexController indexController;

    @Mock
    private Model model;

//    @Mock
//    private RecipeRepository recipeRepository;

    @Mock
    private RecipeServiceImpl recipeService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks( this);
        indexController = new IndexController(recipeService);
    }


    @Test
    public void getIndexPage() {
      String s =  indexController.getIndexPage(model);
      assertEquals( s,"index");
      Set set = new HashSet<Recipe>();
      when(recipeService.getRecipes()).thenReturn( set);
      verify( recipeService, times(1)).getRecipes();
      verify( model, times(1)).addAttribute("recipes",set );



    }
}