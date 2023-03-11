// Given you have T websites on a server. You have to serve data for each website from your server in such a way that no websites remain unresponsive for more than a minute.


// Each of your websites contains;

// Home page

// About Us page

// Contact Us page



// Each page listed has the following content with a maximum size that needs to be served:

// Text content piece - 5 MB each

// Images - Total of 20 MB. Each image is of equal size totalling 20 MB.

// Forms - Total of 5 MB. Each form is of equal size.



// Take into account that for each website to be considered operational, we consider only loading the homepage. And the priority is that we need to load the content first, then the images and finally the forms.


// A noted improvement is that the more images on the homepage perform better to keep the page operational, so the server favours the homepage with less content and more images to be served first.


// Write an algorithm to arrange the T input in a way that should be served first to last, given that the maximum server speed is 2 Mbps.



#include <stdio.h>
void sort(int field[][3], int websites){
    int temp[3];
    for(int i=0; i<websites; i++){
        for(int j=0; j<websites; j++){
            if(field[i][0] < field[j][0]){
                temp[0] = field[i][0];
                temp[1] = field[i][1];
                temp[2] = field[i][2];
                field[i][0] = field[j][0];
                field[i][1] = field[j][1];
                field[i][2] = field[j][2];
                field[j][0] = temp[0];
                field[j][1] = temp[1];
                field[j][2] = temp[2];
            }
           if(field[i][0]==field[j][0]){
                if(field[i][1] > field[j][1]){
                    temp[0] = field[i][0];
                    temp[1] = field[i][1];
                    temp[2] = field[i][2];
                    field[i][0] = field[j][0];
                    field[i][1] = field[j][1];
                    field[i][2] = field[j][2];
                    field[j][0] = temp[0];
                    field[j][1] = temp[1];
                    field[j][2] = temp[2];
                }
            }
            if(field[i][0]==field[j][0]){
                if(field[i][1]==field[j][1]){
                    if(field[i][2] < field[j][2]){
                        temp[0] = field[i][0];
                        temp[1] = field[i][1];
                        temp[2] = field[i][2];
                        field[i][0] = field[j][0];
                        field[i][1] = field[j][1];
                        field[i][2] = field[j][2];
                        field[j][0] = temp[0];
                        field[j][1] = temp[1];
                        field[j][2] = temp[2];
                    }
                }
            }
        }
    }
}
int main(){
    int websites;
    scanf("%d", &websites);
    int field[websites][3];
    for(int i=0; i<websites; i++){
        for(int j=0; j<3; j++){
            scanf("%d", &field[i][j]);
        }
    }
    sort(field, websites);
    for(int i=0; i<websites; i++){
        for(int j=0; j<3; j++){
            printf("%d ", field[i][j]);
        }
        printf("\n");
    }

}