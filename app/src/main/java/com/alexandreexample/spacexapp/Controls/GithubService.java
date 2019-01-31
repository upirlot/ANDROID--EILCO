package com.alexandreexample.spacexapp.Controls;

import com.alexandreexample.spacexapp.Models.Capsule;
import com.alexandreexample.spacexapp.Models.Core;
import com.alexandreexample.spacexapp.Models.Dragon;
import com.alexandreexample.spacexapp.Models.Launch;
import com.alexandreexample.spacexapp.Models.Mission;
import com.alexandreexample.spacexapp.Models.Rocket;
import com.alexandreexample.spacexapp.Models.Ship;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {

    String ENDPOINT = "https://api.spacexdata.com";

    /* Capsule */

    @GET("/v3/capsules")
    Call<List<Capsule>> getAllCapsules();

    @GET("/v3/capsules/{capsuleSerial}")
    Call<Capsule> getOneCapsule(@Path("capsuleSerial") String capsuleSerial);

    @GET("/v3/capsules/past")
    Call<List<Capsule>> getPastCapsules();

    @GET("/v3/capsules/upcoming")
    Call<List<Capsule>> getUpcomingCapsules();

    /* Core */

    @GET("/v3/core")
    Call<List<Core>> getAllCores();

    @GET("/v3/core/{coreSerial}")
    Call<Core> getOneCore(@Path("capsuleSerial") String coreSerial);

    @GET("/v3/core/past")
    Call<List<Core>> getPastCores();

    @GET("/v3/core/upcoming")
    Call<List<Core>> getUpcomingCores();

    /* Dragon */

    @GET("/v3/dragon")
    Call<List<Dragon>> getAllDragons();

    @GET("/v3/dragon/{id}")
    Call<Dragon> getOneDragon(@Path("id") String id);

    /* Rocket */

    @GET("/v3/rockets")
    Call<List<Rocket>> getAllRockets();

    @GET("/v3/rockets/{rocketId}")
    Call<Rocket> getOneRocket(@Path("rocketId") String rocketId);

    /* Launch */

    @GET("/v3/launches")
    Call<List<Launch>> getAllLaunches();

    @GET("/v3/launches/{flightNumber}")
    Call<Launch> getOneLaunch(@Path("flightNumber") int flightNumber);

    @GET("/v3/launches/past")
    Call<List<Launch>> getPastLaunches();

    @GET("/v3/launches/upcoming")
    Call<List<Launch>> getUpcomingLaunches();

    @GET("/v3/launches/latest")
    Call<Launch> getLatestLaunch();

    @GET("/v3/launches/next")
    Call<Launch> getNextLaunch();

    /* Ship */

    @GET("/v3/ships")
    Call<List<Ship>> getAllShips();

    @GET("/v3/ships/{shipId}")
    Call<Ship> getOneShip(@Path("shipId") String shipId);

    /* Mission */

    @GET("/v3/missions")
    Call<List<Mission>> getAllMissions();

    @GET("/v3/missions/{missionId}")
    Call<Mission> getOneMission(@Path("missionId") String missionId);

    GithubService githubService = new Retrofit.Builder()
            .baseUrl(GithubService.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService.class);

}
