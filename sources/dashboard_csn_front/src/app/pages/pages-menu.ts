import { NbMenuItem } from '@nebular/theme';
// Menu ROLE_CENTRAL
export const MENU_ITEMS_CENTRAL: NbMenuItem[] = [
  {
    title: 'EQUIP.HS',
    icon: 'map-outline',
    link: '/pages/maps/gmaps',
    home: true,
  },
  {
    title: 'DASH.INCIDENTS',
    icon: 'pie-chart-outline',
    link: '/pages/dashboard/dashboard-incidents',
  },
];
// Menu ROLE_ADMIN
export const MENU_ITEMS_ADMIN: NbMenuItem[] = [
  {
    title: 'INC.ACTIVITÉ',
    icon: 'message-circle-outline',
    link: '/pages/incidents-activite/incidents-ouverts',
    home: true,
  },
];

// Menu ROLE_ALL
export const MENU_ITEMS_ALL: NbMenuItem[] = [...MENU_ITEMS_ADMIN, ...MENU_ITEMS_CENTRAL];
